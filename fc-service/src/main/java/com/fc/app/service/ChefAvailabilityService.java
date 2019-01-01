package com.fc.app.service;

import java.util.List;

import com.fc.app.model.ChefAvailability;

public interface ChefAvailabilityService {

	List<ChefAvailability> getAllChefsAvailabilities();
	
	List<ChefAvailability> getAllAvailabilitiesForChef(Long chefId);
	
	List<ChefAvailability> persistAvailabilities(List<ChefAvailability> availabilites);
}
