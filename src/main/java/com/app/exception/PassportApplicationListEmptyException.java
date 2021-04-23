package com.app.exception;

public class PassportApplicationListEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public PassportApplicationListEmptyException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "PassportApplicationListEmptyException [message=" + message + "]";
	}
}
