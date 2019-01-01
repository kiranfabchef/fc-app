package com.fc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.app.model.ChefAvailability;

@Repository
public interface ChefAvailabilityRepository extends JpaRepository<ChefAvailability, Long>{

	List<ChefAvailability> findByChefId(Long chefId);

}
