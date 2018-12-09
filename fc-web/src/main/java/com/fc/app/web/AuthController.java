package com.fc.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fc.app.model.UserAuth;
import com.fc.app.service.AuthService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/auth")

public class AuthController {
	
	@Autowired
	private AuthService authService;

	@ApiOperation(value = "Authenticate user credentials", response = Boolean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully completed the request"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(path="/", method=RequestMethod.POST)
	public ResponseEntity<Boolean> auth(@RequestBody UserAuth userAuth) {
		ResponseEntity<Boolean> response = null;
		boolean isAuthorized = false;
		try {
			isAuthorized = authService.auth(userAuth);
			response = new ResponseEntity<>(isAuthorized, HttpStatus.OK);
		}catch(Exception e) {
			response = new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return response;
	}
}
