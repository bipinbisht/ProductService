package com.bipin.ProductService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bipin.ProductService.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = GenericException.class)
	public ResponseEntity<ErrorResponse> handleGenericException(CategoryNotFoundException ex) {
		ErrorResponse er = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
		ErrorResponse er = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = CategoryNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCategoryNotFoundException(CategoryNotFoundException ex) {
		ErrorResponse er = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
	}

}
