package com.fc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.app.model.ChefSlot;

@Repository
public interface RefChefSlotRepository extends JpaRepository<ChefSlot, Long> {

}
