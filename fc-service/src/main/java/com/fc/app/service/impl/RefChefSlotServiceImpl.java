package com.fc.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fc.app.model.ChefSlot;
import com.fc.app.repository.RefChefSlotRepository;
import com.fc.app.service.RefChefSlotService;

@Service
public class RefChefSlotServiceImpl implements RefChefSlotService {
	
	@Autowired
	private RefChefSlotRepository repo;

	@Override
	public List<ChefSlot> getChefSlots() {
		return repo.findAll();
	}

	@Override
	public Optional<ChefSlot> getChefSlotById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<ChefSlot> getAllChefSlotsByExample(ChefSlot example) {
		return repo.findAll(Example.of(example));
	}

	@Override
	public ChefSlot save(ChefSlot chefSlot) {
		return repo.save(chefSlot);
	}

	@Override
	public List<ChefSlot> saveAll(Iterable<ChefSlot> chefSlotList) {
		return repo.saveAll(chefSlotList);
	}

}
