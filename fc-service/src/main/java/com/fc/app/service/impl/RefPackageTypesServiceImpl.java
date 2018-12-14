package com.fc.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fc.app.model.RefPackageTypes;
import com.fc.app.repository.RefPackageTypesRepository;
import com.fc.app.service.RefPackageTypesService;

@Service
public class RefPackageTypesServiceImpl implements RefPackageTypesService{

	@Autowired
	private RefPackageTypesRepository repo;

	@Override
	public List<RefPackageTypes> getAllPackageTypes() {
		return repo.findAll();
	}

	@Override
	public Optional<RefPackageTypes> getPackageTypesById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<RefPackageTypes> getAllPackageTypesByExample(RefPackageTypes example) {
		return repo.findAll(Example.of(example));
	}

	@Override
	public RefPackageTypes save(RefPackageTypes packageType) {
		return repo.save(packageType);
	}

	@Override
	public List<RefPackageTypes> saveAll(Iterable<RefPackageTypes> packageTypesList) {
		return repo.saveAll(packageTypesList);
	}
}
