package com.fc.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fc.app.FcApiErrorResponse;
import com.fc.app.model.UserAuth;
import com.fc.app.service.AuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
@Api(tags={ "auth" }, description="Operations pertaining to authentication")
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@ApiOperation(value = "Authenticate user credentials", response = Boolean.class)
	@RequestMapping(path="/", method=RequestMethod.POST)
	@FcApiErrorResponse
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
