package com.minisense.desafio.exceptions;

public class DatabaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private static final String EXCEPTION_CODE = "database.integrity.violation.exception";
	
	public DatabaseException() {
		super(EXCEPTION_CODE);
	}
}
