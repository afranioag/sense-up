package com.minisense.desafio.exceptions;

public class UnauthorizedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private static final String EXCEPTION_CODE = "error.unauthorized.exception";

	public UnauthorizedException() {
		super(EXCEPTION_CODE);
	}
}
