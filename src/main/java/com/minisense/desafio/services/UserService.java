package com.minisense.desafio.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minisense.desafio.dto.UserDto;
import com.minisense.desafio.entities.User;
import com.minisense.desafio.exceptions.DatabaseException;
import com.minisense.desafio.exceptions.UserNotFoundException;
import com.minisense.desafio.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public UserDto saveUser (UserDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setUserName(dto.getUserName());
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
			User user = userRepository.getReferenceById(id);
			user.setEmail(dto.getEmail());
			user.setUserName(dto.getUserName());
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

}



