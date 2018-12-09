package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.RefChefSlot;

public interface RefChefSlotService {

	public List<RefChefSlot> getChefSlots();

	public Optional<RefChefSlot> getChefSlotById(Long id);

	public List<RefChefSlot> getAllChefSlotsByExample(RefChefSlot example);

	public RefChefSlot save(RefChefSlot chefSlot);

	public List<RefChefSlot> saveAll(Iterable<RefChefSlot> chefSlotList);

}
