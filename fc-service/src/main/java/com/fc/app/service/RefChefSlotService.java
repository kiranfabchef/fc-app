package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.ChefSlot;

public interface RefChefSlotService {

	public List<ChefSlot> getChefSlots();

	public Optional<ChefSlot> getChefSlotById(Long id);

	public List<ChefSlot> getAllChefSlotsByExample(ChefSlot example);

	public ChefSlot save(ChefSlot chefSlot);

	public List<ChefSlot> saveAll(Iterable<ChefSlot> chefSlotList);

}
