package com.fc.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fc.app.model.RefCategoryTypes;
import com.fc.app.repository.RefCategoryTypesRepository;
import com.fc.app.service.RefCategoryTypesService;

@Service
public class RefCategoryTypesServiceImpl implements RefCategoryTypesService {
	
	@Autowired
	private RefCategoryTypesRepository categoryTypesRepository;

	@Override
	public List<RefCategoryTypes> getAllCategoryTypes() {
		return categoryTypesRepository.findAll();
	}

	@Override
	public Optional<RefCategoryTypes> getRefCategoryTypeById(Long id) {
		return categoryTypesRepository.findById(id);
	}

	@Override
	public List<RefCategoryTypes> getAllRefCategoryTypesByExample(RefCategoryTypes example) {
		return categoryTypesRepository.findAll(Example.of(example));
	}

	@Override
	public RefCategoryTypes save(RefCategoryTypes refCategoryType) {
		return categoryTypesRepository.save(refCategoryType);
	}

	@Override
	public List<RefCategoryTypes> saveAll(Iterable<RefCategoryTypes> refCategoryTypes) {
		return categoryTypesRepository.saveAll(refCategoryTypes);
	}

}
