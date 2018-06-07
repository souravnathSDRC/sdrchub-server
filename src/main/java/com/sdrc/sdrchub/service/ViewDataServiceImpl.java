package com.sdrc.sdrchub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdrc.sdrchub.domain.EntryDetails;
import com.sdrc.sdrchub.models.ViewDataModel;
import com.sdrc.sdrchub.repository.SaveEntryDataRepository;

@Service
public class ViewDataServiceImpl implements ViewDataService{
	
	@Autowired
	private SaveEntryDataRepository entryDetailsRepository;
	
	
	@Override
	public List<EntryDetails> getAllData(Integer moduleId, Integer platformId) throws Exception {
		// TODO Auto-generated method stub
		if(moduleId != null && platformId != null)
			return entryDetailsRepository.findByModuleIdAndPlatformIdAndIsLive(moduleId, platformId, true);
		else if(moduleId != null && platformId == null)
			return entryDetailsRepository.findByModuleIdAndIsLive(moduleId, true);
		else if(moduleId == null && platformId != null)
			return entryDetailsRepository.findByPlatformIdAndIsLive(platformId, true);
		else
			return entryDetailsRepository.findByIsLive(true);
			
	}
}
