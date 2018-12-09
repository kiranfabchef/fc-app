package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.Cuisine;

public interface CuisineService {

	public List<Cuisine> getAllCuisines();
	
	public Optional<Cuisine> getCuisineById(Long id);
	
	public List<Cuisine> getAllCuisinesByExample(Cuisine example);
	
	public Cuisine save(Cuisine chef);
	
	public List<Cuisine> saveAll(Iterable<Cuisine> chefs);
}
