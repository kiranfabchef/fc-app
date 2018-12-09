package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.Chef;


public interface ChefService {
	
	public List<Chef> getAllChefs();
	
	public Optional<Chef> getChefById(Long id);
	
	public List<Chef> getAllChefsByExample(Chef example);
	
	public Chef save(Chef chef);
	
	public List<Chef> saveAll(Iterable<Chef> chefs);

	public Chef findByUserNamePassword(String userName, String password);

}
