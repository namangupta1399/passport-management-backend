package com.app.exception;

public class PasswordInvalidException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public PasswordInvalidException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "PasswordInvalidException [message=" + message + "]";
	}
}
