package com.fc.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fc.app.model.Cuisine;
import com.fc.app.repository.CuisineRepository;
import com.fc.app.service.CuisineService;

@Service
public class CuisineServiceImpl implements CuisineService {
	
	@Autowired
	private CuisineRepository cuisineRepo;

	@Override
	public List<Cuisine> getAllCuisines() {
		return cuisineRepo.findAll();
	}

	@Override
	public Optional<Cuisine> getCuisineById(Long id) {
		return cuisineRepo.findById(id);
	}

	@Override
	public List<Cuisine> getAllCuisinesByExample(Cuisine example) {
		return cuisineRepo.findAll(Example.of(example));
	}

	@Override
	public Cuisine save(Cuisine chef) {
		return cuisineRepo.save(chef);
	}

	@Override
	public List<Cuisine> saveAll(Iterable<Cuisine> chefs) {
		return cuisineRepo.saveAll(chefs);
	}

}
