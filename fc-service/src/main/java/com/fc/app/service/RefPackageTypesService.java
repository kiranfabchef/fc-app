package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.RefPackageTypes;

public interface RefPackageTypesService {

	List<RefPackageTypes> getAllPackageTypes();

	Optional<RefPackageTypes> getPackageTypesById(Long id);

	List<RefPackageTypes> getAllPackageTypesByExample(RefPackageTypes example);

	RefPackageTypes save(RefPackageTypes packageType);

	List<RefPackageTypes> saveAll(Iterable<RefPackageTypes> packageTypesList);

}
