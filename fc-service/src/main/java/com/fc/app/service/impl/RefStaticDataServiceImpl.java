package com.fc.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fc.app.model.RefStaticData;
import com.fc.app.repository.RefStaticDataRepository;
import com.fc.app.service.RefStaticDataService;

@Service
public class RefStaticDataServiceImpl implements RefStaticDataService {

	@Autowired
	private RefStaticDataRepository staticDataRepository;
	
	@Override
	public List<RefStaticData> getAllStaticData() {
		return staticDataRepository.findAll();
	}

	@Override
	public Optional<RefStaticData> getRefStaticDataById(Long id) {
		return staticDataRepository.findById(id);
	}

	@Override
	public List<RefStaticData> getAllRefStaticDataListByExample(RefStaticData staticData) {
		return staticDataRepository.findAll(Example.of(staticData));
	}

	@Override
	public RefStaticData save(RefStaticData refStaticData) {
		return staticDataRepository.save(refStaticData);
	}

	@Override
	public List<RefStaticData> saveAll(Iterable<RefStaticData> refStaticDataList) {
		return staticDataRepository.saveAll(refStaticDataList);
	}

}
