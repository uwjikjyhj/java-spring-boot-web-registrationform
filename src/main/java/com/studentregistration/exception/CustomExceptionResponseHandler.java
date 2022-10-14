package com.studentregistration.exception;

import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionResponseHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public final ExceptionResponse handleAllExceptions(Exception ex, WebRequest req) {
		System.out.println(ex);
		ExceptionResponse expRes = new ExceptionResponse(
				new Date(), ex.getMessage(), "Invalid request");
		return expRes;
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public final ExceptionResponse handleStudentNotFoundException(StudentNotFoundException ex, WebRequest req) {
		ExceptionResponse expRes = new ExceptionResponse(
				new Date(), ex.getMessage(), "The requested student ID is not found");
		return expRes;
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public final ExceptionResponse handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest req) {
		System.out.println("Inside handleDataIntegrityViolationException");
		ExceptionResponse expRes = new ExceptionResponse(
				new Date(), ex.getMessage(), "The requested input violates database contraints");
		return expRes;
	}
}
