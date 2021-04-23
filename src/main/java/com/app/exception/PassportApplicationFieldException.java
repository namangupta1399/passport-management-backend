package com.app.exception;

public class PassportApplicationFieldException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public PassportApplicationFieldException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "PassportApplicationFieldException [message=" + message + "]";
	}
}
