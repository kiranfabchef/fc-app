package com.fc.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;


//@ControllerAdvice
public class FcExceptionHandler extends BaseExceptionHandler{

	private final static Logger LOGGER = LoggerFactory.getLogger(FcExceptionHandler.class);
	public FcExceptionHandler(Logger LOGGER) {
		super(LOGGER);
		
		registerMapping(RuntimeException.class, HttpStatus.INTERNAL_SERVER_ERROR.name(), "Internal server error", 
				HttpStatus.INTERNAL_SERVER_ERROR);
		registerMapping(Throwable.class, HttpStatus.EXPECTATION_FAILED.name(), "Unknown Error", HttpStatus.EXPECTATION_FAILED);
	}

}
