package com.sdrc.sdrchub.service;

import java.util.List;

import com.sdrc.sdrchub.domain.EntryDetails;
import com.sdrc.sdrchub.domain.TypeDetails;

public interface DataEntryService {

	String saveData(EntryDetails entryData) throws Exception;
	String uploadFiles(EntryDetails entryDetails, Integer referenceId) throws Exception;
	List<TypeDetails> getModulesAndPlatforms() throws Exception;
}
