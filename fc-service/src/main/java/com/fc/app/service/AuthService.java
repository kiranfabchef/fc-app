package com.fc.app.service;

import com.fc.app.model.UserAuth;

public interface AuthService {

	static final String CHEF = "CHEF";
	
	public boolean auth(UserAuth userAuth);
}
