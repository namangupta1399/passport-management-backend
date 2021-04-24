package com.app.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, HttpServletRequest request) throws UserNotFoundException {
				ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.NOT_FOUND);
				
				return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PassportApplicationNotFoundException.class)
	public ResponseEntity<Object> handlePassportApplicationNotFoundException(PassportApplicationNotFoundException ex, HttpServletRequest request) throws PassportApplicationNotFoundException {
				ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.NOT_FOUND);
				
				return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PassportApplicationAlreadyExists.class)
	public ResponseEntity<Object> handlePassportApplicationAlreadyExistException(PassportApplicationAlreadyExists ex, HttpServletRequest request)
			throws PassportApplicationAlreadyExists {

		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException ex, HttpServletRequest request)
			throws UserAlreadyExistException {

		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(PassportNotFoundException.class)
	public ResponseEntity<Object> handlePassportNotFoundException(PassportNotFoundException ex, HttpServletRequest request) throws PassportNotFoundException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HelpdeskQueryNotFoundException.class)
	public ResponseEntity<Object> handleHelpdeskQueryNotFoundException(HelpdeskQueryNotFoundException ex, HttpServletRequest request) throws HelpdeskQueryNotFoundException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DocumentNotFoundException.class)
	public ResponseEntity<Object> handleDocumentNotFoundException(DocumentNotFoundException ex, HttpServletRequest request) throws DocumentNotFoundException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PassportApplicationListEmptyException.class)
	public ResponseEntity<Object> handlePassportApplicationListEmptyException(PassportApplicationListEmptyException ex, HttpServletRequest request) throws PassportApplicationListEmptyException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserListEmptyException.class)
	public ResponseEntity<Object> handleUserListEmptyException(UserListEmptyException ex, HttpServletRequest request) throws UserListEmptyException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HelpdeskQueryListEmptyException.class)
	public ResponseEntity<Object> handleHelpdeskQueryListEmptyException(HelpdeskQueryListEmptyException ex, HttpServletRequest request) throws HelpdeskQueryListEmptyException {
				ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.NOT_FOUND);
				
				return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PasswordInvalidException.class)
	public ResponseEntity<Object> handlePasswordInvalidException(PasswordInvalidException ex, HttpServletRequest request) throws PasswordInvalidException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getRequestURI(), HttpStatus.FORBIDDEN);
		
		return new ResponseEntity<>(resp, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(EmailInvalidException.class)
	public ResponseEntity<Object> handleEmailInvalidException(EmailInvalidException ex, HttpServletRequest request) throws EmailInvalidException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(), request.getRequestURI(), HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserRoleInvalidException.class)
	public ResponseEntity<Object> handleUserRoleInvalidException(UserRoleInvalidException ex, HttpServletRequest request) throws UserRoleInvalidException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(), request.getRequestURI(), HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PassportApplicationFieldException.class)
	public ResponseEntity<Object> handlePassportApplicationFieldException(PassportApplicationFieldException ex, HttpServletRequest request) throws PassportApplicationFieldException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(), request.getRequestURI(), HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HelpdeskQueryException.class)
	public ResponseEntity<Object> handleHelpdeskQueryException(HelpdeskQueryException ex, HttpServletRequest request) throws HelpdeskQueryException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(), request.getRequestURI(), HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PassportAlreadyIssuedException.class)
	public ResponseEntity<Object> handlePassportAlreadyIssuedException(PassportAlreadyIssuedException ex, HttpServletRequest request) throws PassportAlreadyIssuedException {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(), request.getRequestURI(), HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
