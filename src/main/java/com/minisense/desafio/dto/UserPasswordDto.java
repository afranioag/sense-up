package com.minisense.desafio.dto;

public class UserPasswordDto extends UserDto {
	private static final long serialVersionUID = 1L;

	private String password;

	public UserPasswordDto() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
