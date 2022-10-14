package com.studentregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicateEntryException extends RuntimeException {
	public DuplicateEntryException(String msg) {
		super(msg);
	}
}
