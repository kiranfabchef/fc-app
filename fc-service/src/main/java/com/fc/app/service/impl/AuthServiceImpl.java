package com.fc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.app.model.Chef;
import com.fc.app.model.UserAuth;
import com.fc.app.service.AuthService;
import com.fc.app.service.ChefService;

@Service
public class AuthServiceImpl implements AuthService{
	

	@Autowired
	private ChefService chefService;

	@Override
	public boolean auth(UserAuth userAuth) {
		if(CHEF.equalsIgnoreCase(userAuth.getUserType())) {
			Chef chef = chefService.findByUserNamePassword(userAuth.getUserName(), userAuth.getPassword());
			if(null!=chef) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

}
