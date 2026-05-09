package com.daniel.taskmanagerapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex){
		return ResponseEntity
				.badRequest()
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<String> handleIllegalState(IllegalStateException ex){
		return ResponseEntity
				.badRequest()
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex){
		String message = ex
				.getBindingResult()
				.getFieldError()
				.getDefaultMessage();
		
		return ResponseEntity
				.badRequest()
				.body(message);
	}
}
