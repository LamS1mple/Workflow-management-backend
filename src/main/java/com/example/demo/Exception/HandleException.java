package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HandleException {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorMessage> handelRuntime(NullPointerException exception, WebRequest webRequest) {
		
		return  ResponseEntity.badRequest().body(ErrorMessage.builder()
				.httpStatus(HttpStatus.NOT_FOUND)
				.code(2000)
				.message(exception.getMessage())
				.build());
	}
}
