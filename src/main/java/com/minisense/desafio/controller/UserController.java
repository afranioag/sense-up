package com.minisense.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minisense.desafio.dto.UserDto;
import com.minisense.desafio.services.UserService;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public HttpStatus save( @RequestBody UserDto userDto ) {
		userService.saveUser(userDto);
		
		return HttpStatus.OK;
	}
	
	
	@GetMapping(value = "/{id}")
	public UserDto findById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@GetMapping
	public List<UserDto> findAll(){
		return userService.finalAll();
	}
	
	
	

	
	
}
