package com.app.exception;

public class PassportApplicationAlreadyExists extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public PassportApplicationAlreadyExists(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "PassportApplicationAlreadyExists [message=" + message + "]";
	}
}