package com.fc.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fc.app.model.RefVenueDetails;
import com.fc.app.repository.RefVenueDetailsRepository;
import com.fc.app.service.RefVenueDetailsService;

@Service
public class RefVenueDetailsServiceImpl implements RefVenueDetailsService {
	
	@Autowired
	private RefVenueDetailsRepository repo;

	@Override
	public List<RefVenueDetails> getAllVenueDetails() {
		return repo.findAll();
	}

	@Override
	public Optional<RefVenueDetails> getVenueDetailsById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<RefVenueDetails> getAllVenueDetailsByExample(RefVenueDetails example) {
		return repo.findAll(Example.of(example));
	}

	@Override
	public RefVenueDetails save(RefVenueDetails venueDetails) {
		return repo.save(venueDetails);
	}

	@Override
	public List<RefVenueDetails> saveAll(Iterable<RefVenueDetails> venueDetailsList) {
		return repo.saveAll(venueDetailsList);
	}

}
