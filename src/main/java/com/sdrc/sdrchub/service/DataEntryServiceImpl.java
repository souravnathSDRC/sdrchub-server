package com.sdrc.sdrchub.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdrc.sdrchub.domain.EntryDetails;
import com.sdrc.sdrchub.domain.TypeDetails;
import com.sdrc.sdrchub.repository.SaveEntryDataRepository;
import com.sdrc.sdrchub.repository.TypeDetailsRepository;

@Service
public class DataEntryServiceImpl implements DataEntryService {

	@Autowired
	SaveEntryDataRepository saveEntryDataRepository;
	
	@Autowired
	TypeDetailsRepository typeDetailsRepository;
	
	@Override
	public String saveData(EntryDetails entryData) throws Exception {
		// TODO Auto-generated method stub
		EntryDetails currentSubmission=null;
		if(entryData.getCreatedDate() == null)
			entryData.setCreatedDate(new Timestamp(new Date().getTime()));
		entryData.setUpdatedDate(new Timestamp(new Date().getTime()));
		entryData.setLive(true);
		currentSubmission = saveEntryDataRepository.save(entryData);


		
		return currentSubmission.getId().toString();
	}
	
	@Override
	public List<TypeDetails> getModulesAndPlatforms() throws Exception {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 2);
//		return typeDetailsRepository.findByTypeLevelId(list);
		return typeDetailsRepository.getTypeLevelId(list);
	}
}
