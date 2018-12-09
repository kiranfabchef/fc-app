package com.fc.app;

import org.springframework.web.bind.annotation.ResponseStatus;

public class ChefNotFoundException extends RuntimeException{

	public ChefNotFoundException(String message){
		super(message);
	}
	
	public ChefNotFoundException() {
		super();
	}
	
}
