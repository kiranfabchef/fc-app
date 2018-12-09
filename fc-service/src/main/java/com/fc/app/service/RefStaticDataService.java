package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.RefStaticData;

public interface RefStaticDataService {

	public List<RefStaticData> getAllStaticData();
	
	public Optional<RefStaticData> getRefStaticDataById(Long id);
	
	public List<RefStaticData> getAllRefStaticDataListByExample(RefStaticData example);
	
	public RefStaticData save(RefStaticData refStaticData);
	
	public List<RefStaticData> saveAll(Iterable<RefStaticData> refStaticDataList);
}
