package com.fc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.app.model.RefCuisine;

@Repository
public interface RefCuisineRepository extends JpaRepository<RefCuisine, Long>{

}
