package com.app.exception;

public class PassportApplicationNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public PassportApplicationNotFoundException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "PassportApplicationNotFoundException [message=" + message + "]";
	}
}
