package com.fc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.app.model.RefCategoryTypes;

@Repository
public interface RefCategoryTypesRepository extends JpaRepository<RefCategoryTypes, Long> {

}
