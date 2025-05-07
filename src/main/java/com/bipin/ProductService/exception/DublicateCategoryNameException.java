package com.bipin.ProductService.exception;

public class DublicateCategoryNameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4606129485962325276L;

	public DublicateCategoryNameException() {

	}

	public DublicateCategoryNameException(String msg) {
		super(msg);
	}

}
