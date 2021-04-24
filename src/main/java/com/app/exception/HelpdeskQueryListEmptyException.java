package com.app.exception;

public class HelpdeskQueryListEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public HelpdeskQueryListEmptyException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "HelpdeskQueryListEmptyException [message=" + message + "]";
	}
}
