package com.app.exception;

public class PassportNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public PassportNotFoundException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "PassportNotFoundException [message=" + message + "]";
	}
	
}
