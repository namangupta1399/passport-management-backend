package com.app.exception;

public class EmailInvalidException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public EmailInvalidException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "EmailInvalidException [message=" + message + "]";
	}
}