package com.studentregistration.exception;

import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionResponseHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public final ExceptionResponse handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse expRes = new ExceptionResponse(
				new Date(), ex.getMessage(), "Invalid request");
		return expRes;
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public final ExceptionResponse handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request) {
		ExceptionResponse expRes = new ExceptionResponse(
				new Date(), ex.getMessage(), "The requested student ID is not found");
		return expRes;
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public final ExceptionResponse handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
		ExceptionResponse expRes = new ExceptionResponse(
				new Date(), ex.getMessage(), "The requested input violates database contraints");
		return expRes;
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("Inside handleMethodArgumentNotValid");
		ExceptionResponse expRes = new ExceptionResponse(
				new Date(), "Validation failed", ex.getBindingResult().toString());
		return new ResponseEntity(expRes, HttpStatus.BAD_REQUEST);
	}
}
