package com.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {

	private Date currentDate;
	
	private String message;
	
	private String path;
	private HttpStatus status;
	
	public ExceptionResponse() {}
	
	public ExceptionResponse(Date currentDate, String message, String path, HttpStatus internalServerError) {
		super();
		this.currentDate = currentDate;
		this.message = message;
		this.path = path;
		this.status = internalServerError;
	}
	
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PassportExceptionResponse [currentDate=" + currentDate + ", message=" + message + ", path=" + path
				+ ", status=" + status + "]";
	}
	
}
