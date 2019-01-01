package com.fc.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.app.model.ChefAvailability;
import com.fc.app.repository.ChefAvailabilityRepository;
import com.fc.app.service.ChefAvailabilityService;

@Service
public class ChefAvailabilityServiceImpl implements ChefAvailabilityService {
	
	@Autowired
	private ChefAvailabilityRepository repo;

	@Override
	public List<ChefAvailability> getAllChefsAvailabilities() {
		return repo.findAll();
	}

	@Override
	public List<ChefAvailability> getAllAvailabilitiesForChef(Long chefId) {
		return repo.findByChefId(chefId);
	}

	@Override
	public List<ChefAvailability> persistAvailabilities(List<ChefAvailability> availabilites) {
		return repo.saveAll(availabilites);
	}

}
