package com.minisense.desafio.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.minisense.desafio.entities.User;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String userName;
	private String email;
	
	Set<RoleDto> roles = new HashSet<>();
	
	
	public UserDto() {}
	
	public UserDto(Long id, String userName, String email) {
		this.id = id;
		this.userName = userName;
		this.email = email;
	}

	public UserDto(User user) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.email = user.getEmail();
		user.getRoles().forEach(role -> this.roles.add(new RoleDto(role)));
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
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
