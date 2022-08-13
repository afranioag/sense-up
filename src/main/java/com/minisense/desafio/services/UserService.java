package com.minisense.desafio.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minisense.desafio.dto.RoleDto;
import com.minisense.desafio.dto.UserDto;
import com.minisense.desafio.dto.UserInsertDto;
import com.minisense.desafio.entities.Role;
import com.minisense.desafio.entities.User;
import com.minisense.desafio.exceptions.DatabaseException;
import com.minisense.desafio.exceptions.UserNotFoundException;
import com.minisense.desafio.repositories.RoleRepository;
import com.minisense.desafio.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	public UserDto save(UserInsertDto dto) {
		User user = new User();
		copyDtoUser(dto, user);
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		return new UserDto(userRepository.save(user));
	}
	
	@Transactional(readOnly = true)
	public List<UserDto> finalAll() {
		return userRepository.findAll().stream().map(u -> new UserDto(u))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDto findById(Long id) {
		Optional<User> userOpt = userRepository.findById(id);
		User user = userOpt.orElseThrow(() -> new UserNotFoundException());
		return new UserDto(user);
	}
	
	@Transactional
	public UserDto update(Long id, UserDto dto) {
		try {
			User user = userRepository.getOne(id);
			copyDtoUser(dto, user);
			user = userRepository.save(user);
			return new UserDto(user);
		}
		catch (EntityNotFoundException e) {
			throw new UserNotFoundException();
		}
	}

	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new UserNotFoundException();
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException();
		}	
	}

	private void copyDtoUser(UserDto dto, User user) {
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.getRoles().clear();
		for(RoleDto roleDto: dto.getRoles()) {
			Role role = roleRepository.getOne(roleDto.getId());
			user.getRoles().add(role);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			logger.error("User not found for email: " + username);
			throw new UsernameNotFoundException("Email not found");
		}

		logger.info("User found: " + username);
		return user;
	}
}



