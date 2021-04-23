package com.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
				ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);
				
				return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PassportApplicationNotFoundException.class)
	public ResponseEntity<Object> handlePassportApplicationNotFoundException(PassportApplicationNotFoundException ex, WebRequest request) throws Exception {
				ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);
				
				return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PassportApplicationAlreadyExists.class)
	public ResponseEntity<Object> handlePassportApplicationAlreadyExistException(PassportApplicationAlreadyExists ex, WebRequest request)
			throws Exception {

		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException ex, WebRequest request)
			throws Exception {

		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(PassportNotFoundException.class)
	public ResponseEntity<Object> handlePassportNotFoundException(PassportNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HelpdeskQueryNotFoundException.class)
	public ResponseEntity<Object> handleHelpdeskQueryNotFoundException(HelpdeskQueryNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DocumentNotFoundException.class)
	public ResponseEntity<Object> handleDocumentNotFoundException(DocumentNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PassportApplicationListEmptyException.class)
	public ResponseEntity<Object> handlePassportApplicationListEmptyException(PassportApplicationListEmptyException ex, WebRequest request) throws Exception {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserListEmptyException.class)
	public ResponseEntity<Object> handleUserListEmptyException(UserListEmptyException ex, WebRequest request) throws Exception {
		ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HelpdeskQueryListEmptyException.class)
	public ResponseEntity<Object> handleHelpdeskQueryListEmptyException(HelpdeskQueryListEmptyException ex, WebRequest request) throws Exception {
				ExceptionResponse resp = new ExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);
				
				return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(ProductAlreadyExistException.class)
//	public ResponseEntity<Object> handleProductAlreadyExistException(ProductAlreadyExistException ex, WebRequest request)
//			throws Exception {
//
//		GroceryExceptionResponse resp = new GroceryExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
//				request.getContextPath(), HttpStatus.NOT_FOUND);
//
//		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
//
//	}
//	
//	@ExceptionHandler(StockNotAvailableException.class)
//	public ResponseEntity<Object> handleStockNotAvailableException(StockNotAvailableException ex, WebRequest request)
//			throws Exception {
//
//		GroceryExceptionResponse resp = new GroceryExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
//				request.getContextPath(), HttpStatus.NOT_FOUND);
//
//		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
//
//	}
//	
//	@ExceptionHandler(InvalidPasswordException.class)
//	public ResponseEntity<Object> handleInvalidPasswordException(InvalidPasswordException ex, WebRequest request)
//			throws Exception {
//
//		GroceryExceptionResponse resp = new GroceryExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
//				request.getContextPath(), HttpStatus.NOT_FOUND);
//
//		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
//
//	}
//	
//	@ExceptionHandler(InvalidDetailsException.class)
//	public ResponseEntity<Object> handleInvalidDetailsException(InvalidDetailsException ex, WebRequest request)
//			throws Exception {
//
//	GroceryExceptionResponse resp = new GroceryExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
//				request.getContextPath(), HttpStatus.NOT_FOUND);
//
//		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
//
//	}
//	
//	@ExceptionHandler(EmptyBookingException.class)
//	public ResponseEntity<Object> handleEmptyBookingException(EmptyBookingException ex, WebRequest request)
//			throws Exception {
//
//	GroceryExceptionResponse resp = new GroceryExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
//				request.getContextPath(), HttpStatus.NOT_FOUND);
//
//		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
//
//	}
}
