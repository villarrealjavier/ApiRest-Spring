package com.jacaranda.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jacaranda.demo.error.ApiError;
import com.jacaranda.demo.exception.ElementNotFoundException;

@RestControllerAdvice
public class GlobalControllerError {
	@ExceptionHandler(ElementNotFoundException.class)
	public ResponseEntity<ApiError>
		andleElementNotFoundException(ElementNotFoundException e){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,e.getMessage());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
}
