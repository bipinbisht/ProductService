package com.bipin.ProductService.exception;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException() {

	}

	public ProductNotFoundException(String s) {
		super(s);
	}

}
