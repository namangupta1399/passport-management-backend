package com.app.exception;

public class HelpdeskQueryException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public HelpdeskQueryException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "HelpdeskQueryException [message=" + message + "]";
	}
	
}
