package com.app.exception;

public class UserAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public UserAlreadyExistException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "UserAlreadyExistException [message=" + message + "]";
	}
	
}
