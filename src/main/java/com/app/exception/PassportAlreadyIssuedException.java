package com.app.exception;

public class PassportAlreadyIssuedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public PassportAlreadyIssuedException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "PassportAlreadyIssuedException [message=" + message + "]";
	}
}
