package com.fc.app;

public class FcServicesValidationFailureException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FcServicesValidationFailureException() {
		super();
	}

	public FcServicesValidationFailureException(String message) {
		super(message);
	}

	public FcServicesValidationFailureException(String message, Throwable cause) {
		super(cause);
	}

}
