package com.app.exception;

public class UserRoleInvalidException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public UserRoleInvalidException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "UserRoleInvalidException [message=" + message + "]";
	}
}