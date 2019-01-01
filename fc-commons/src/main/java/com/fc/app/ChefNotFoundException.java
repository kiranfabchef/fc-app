package com.fc.app;

public class ChefNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ChefNotFoundException(String message) {
		super(message);
	}

	public ChefNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChefNotFoundException() {
		super();
	}

}
