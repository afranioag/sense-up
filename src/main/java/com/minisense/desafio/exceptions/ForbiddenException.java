package com.minisense.desafio.exceptions;

public class ForbiddenException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private static final String EXCEPTION_CODE = "error.you.dont.permission.exception";

	public ForbiddenException() {
		super(EXCEPTION_CODE);
	}
}
