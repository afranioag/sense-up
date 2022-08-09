package com.minisense.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minisense.desafio.dto.UserDto;
import com.minisense.desafio.entities.User;
import com.minisense.desafio.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public void saveUser (UserDto dto) {
		User user = new User();
		
		user.setEmail(dto.getEmail());
		user.setUserName(dto.getUserName());
		
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true)
	public List<UserDto> finalAll() {
		return userRepository.findAll().stream().map(u -> new UserDto(u)).toList();
	}
	
	public UserDto findById(Long id) {
		User user = userRepository.findById(id).get();
		
		return new UserDto(user);
	}
}
