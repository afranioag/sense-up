package com.minisense.desafio.exceptions;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private static final String EXCEPTION_CODE = "user.not.found.exception";
	
	public UserNotFoundException() {
		super(EXCEPTION_CODE);
	}
}
