package com.app.exception;

public class UserListEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public UserListEmptyException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "UserListEmptyException [message=" + message + "]";
	}
}
