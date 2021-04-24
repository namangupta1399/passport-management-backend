package com.app.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final String message;
	
	public UserNotFoundException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "UserNotFoundException [message=" + message + "]";
	}
	
}
