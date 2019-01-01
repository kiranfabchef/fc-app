package com.fc.app;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class BaseExceptionHandler {

	private static final ExceptionMapping DEFAULT_ERROR = new ExceptionMapping("SERVER_ERROR", "Internal server error",
			HttpStatus.INTERNAL_SERVER_ERROR);

	private final Logger LOGGER;

	private final Map<Class, ExceptionMapping> exceptionMappings = new HashMap<>();

	public BaseExceptionHandler(final Logger LOGGER) {
		this.LOGGER = LOGGER;
	}

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ErrorResponse handleThrowable(final Throwable ex, final HttpServletResponse response) {
		ExceptionMapping mapping = exceptionMappings.getOrDefault(ex.getClass(), DEFAULT_ERROR);
		response.setStatus(mapping.status.value());
		LOGGER.error("{} ({}): {}", mapping.message, mapping.code, ex.getMessage(), ex);
		return new ErrorResponse(mapping.code, mapping.message);
	}
	
	protected void registerMapping(final Class<?> clazz, final String code, final String message, final HttpStatus status){
		exceptionMappings.put(clazz, new ExceptionMapping(message, code, status));
	}

	public static class ErrorResponse {
		private final String code;
		private final String message;

		public ErrorResponse(String code, String message) {
			super();
			this.code = code;
			this.message = message;
		}

		public String getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

	}

	private static class ExceptionMapping {
		private final String message;
		private final String code;
		private final HttpStatus status;

		public ExceptionMapping(String message, String code, HttpStatus status) {
			super();
			this.message = message;
			this.code = code;
			this.status = status;
		}

	}

}
