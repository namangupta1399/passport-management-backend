package com.app.exception;

public class DocumentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public DocumentNotFoundException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "DocumentNotFoundException [message=" + message + "]";
	}
}
