package com.app.exception;

public class PassportListEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public PassportListEmptyException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "PassportListEmptyException [message=" + message + "]";
	}
}