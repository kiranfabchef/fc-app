package com.fc.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fc.app.model.RefChefSlot;
import com.fc.app.repository.RefChefSlotRepository;
import com.fc.app.service.RefChefSlotService;

@Service
public class RefChefSlotServiceImpl implements RefChefSlotService {
	
	@Autowired
	private RefChefSlotRepository repo;

	@Override
	public List<RefChefSlot> getChefSlots() {
		return repo.findAll();
	}

	@Override
	public Optional<RefChefSlot> getChefSlotById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<RefChefSlot> getAllChefSlotsByExample(RefChefSlot example) {
		return repo.findAll(Example.of(example));
	}

	@Override
	public RefChefSlot save(RefChefSlot chefSlot) {
		return repo.save(chefSlot);
	}

	@Override
	public List<RefChefSlot> saveAll(Iterable<RefChefSlot> chefSlotList) {
		return repo.saveAll(chefSlotList);
	}

}
