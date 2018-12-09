package com.fc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.app.model.RefVenueDetails;

@Repository
public interface RefVenueDetailsRepository extends JpaRepository<RefVenueDetails, Long>{

}
