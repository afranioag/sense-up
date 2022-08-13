package com.minisense.desafio.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.minisense.desafio.entities.User;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	
	Set<RoleDto> roles = new HashSet<>();
	
	
	public UserDto() {}
	
	public UserDto(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		user.getRoles().forEach(role -> this.roles.add(new RoleDto(role)));
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String userName) {
		this.name = userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RoleDto> getRoles() {
		return roles;
	}
	
}
