package com.fc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.app.model.RefChefSlot;

@Repository
public interface RefChefSlotRepository extends JpaRepository<RefChefSlot, Long> {

	RefChefSlot findBySlotId(Long slotId);

}
