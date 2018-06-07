package com.sdrc.sdrchub.repository;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.sdrc.sdrchub.domain.EntryDetails;
import com.sdrc.sdrchub.models.ViewDataModel;

@RepositoryDefinition(idClass=Integer.class,domainClass=EntryDetails.class)
public interface SaveEntryDataRepository {

	@Transactional
	EntryDetails save(EntryDetails entryData);
	
	
	@Transactional
	List<EntryDetails> findByModuleIdAndPlatformId(Integer moduleId, Integer platformId);


	List<EntryDetails> findAll();


	List<EntryDetails> findByPlatformId(Integer platformId);


	List<EntryDetails> findByModuleId(Integer moduleId);


	List<EntryDetails> findByModuleIdAndPlatformIdAndIsLive(Integer moduleId, Integer platformId, boolean b);


	List<EntryDetails> findByIsLive(boolean b);


	List<EntryDetails> findByModuleIdAndIsLive(Integer moduleId, boolean b);


	List<EntryDetails> findByPlatformIdAndIsLive(Integer platformId, boolean b);
}
