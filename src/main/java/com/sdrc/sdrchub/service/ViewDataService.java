package com.sdrc.sdrchub.service;

import java.util.List;

import com.sdrc.sdrchub.domain.EntryDetails;
import com.sdrc.sdrchub.models.ViewDataModel;

public interface ViewDataService {

	List<EntryDetails> getAllData(Integer moduleId, Integer platformId) throws Exception;
}
