package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Builder
public class ErrorMessage{
	private int code ;
	String message;
	HttpStatus httpStatus;
	public int getCode() {
		return code;
	}
	public void setStatusCode(int statusCode) {
		this.code = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
