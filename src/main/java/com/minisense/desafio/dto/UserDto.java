package com.minisense.desafio.dto;

import java.io.Serializable;

import com.minisense.desafio.entities.User;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String userName;
	private String email;
	
	public UserDto() {}
	
	public UserDto(User user) {
		this.userName = user.getUserName();
		this.email = user.getEmail();
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
	
}
