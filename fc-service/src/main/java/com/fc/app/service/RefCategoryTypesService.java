package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.RefCategoryTypes;

public interface RefCategoryTypesService {
	
	public List<RefCategoryTypes> getAllCategoryTypes();

	public Optional<RefCategoryTypes> getRefCategoryTypeById(Long id);

	public List<RefCategoryTypes> getAllRefCategoryTypesByExample(RefCategoryTypes example);

	public RefCategoryTypes save(RefCategoryTypes refCategoryType);

	public List<RefCategoryTypes> saveAll(Iterable<RefCategoryTypes> RefCategoryTypes);
}
