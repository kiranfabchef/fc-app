package com.fc.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fc.app.model.RefCuisine;
import com.fc.app.repository.RefCuisineRepository;
import com.fc.app.service.RefCuisineService;

@Service
public class RefCuisineServiceImpl implements RefCuisineService {
	
	@Autowired
	private RefCuisineRepository cuisineRepo;

	@Override
	public List<RefCuisine> getAllCuisines() {
		return cuisineRepo.findAll();
	}

	@Override
	public Optional<RefCuisine> getCuisineById(Long id) {
		return cuisineRepo.findById(id);
	}

	@Override
	public List<RefCuisine> getAllCuisinesByExample(RefCuisine example) {
		return cuisineRepo.findAll(Example.of(example));
	}

	@Override
	public RefCuisine save(RefCuisine cuisine) {
		return cuisineRepo.save(cuisine);
	}

	@Override
	public List<RefCuisine> saveAll(Iterable<RefCuisine> cuisineList) {
		return cuisineRepo.saveAll(cuisineList);
	}

}
