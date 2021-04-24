package com.app.exception;

public class HelpdeskQueryNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public HelpdeskQueryNotFoundException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "HelpdeskQueryNotFoundException [message=" + message + "]";
	}
}
