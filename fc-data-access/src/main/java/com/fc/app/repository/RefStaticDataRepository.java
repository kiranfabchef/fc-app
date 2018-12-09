package com.fc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.app.model.RefStaticData;

@Repository
public interface RefStaticDataRepository extends JpaRepository<RefStaticData, Long> {

}
