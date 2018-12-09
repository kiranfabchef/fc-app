package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.RefVenueDetails;

public interface RefVenueDetailsService {
	
	public List<RefVenueDetails> getAllVenueDetails();
	
	public Optional<RefVenueDetails> getVenueDetailsById(Long id);
	
	public List<RefVenueDetails> getAllVenueDetailsByExample(RefVenueDetails example);
	
	public RefVenueDetails save(RefVenueDetails venueDetails);
	
	public List<RefVenueDetails> saveAll(Iterable<RefVenueDetails> venueDetailsList);

}
