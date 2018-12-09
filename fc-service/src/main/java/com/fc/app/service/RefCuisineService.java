package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.RefCuisine;

public interface RefCuisineService {

	public List<RefCuisine> getAllCuisines();
	
	public Optional<RefCuisine> getCuisineById(Long id);
	
	public List<RefCuisine> getAllCuisinesByExample(RefCuisine example);
	
	public RefCuisine save(RefCuisine cuisine);
	
	public List<RefCuisine> saveAll(Iterable<RefCuisine> cuisineList);
}
