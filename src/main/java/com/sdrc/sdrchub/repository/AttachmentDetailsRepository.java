package com.sdrc.sdrchub.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.RepositoryDefinition;

import com.sdrc.sdrchub.domain.AttachmentDetails;
import com.sdrc.sdrchub.domain.EntryDetails;

@RepositoryDefinition(idClass=Integer.class,domainClass=AttachmentDetails.class)
public interface AttachmentDetailsRepository {
	
	@Transactional
	AttachmentDetails save(AttachmentDetails attachment);
	
	@Transactional
	List<AttachmentDetails> findByReferenceEntryIdAndDocumentName(Integer referenceEntryId, String documentName);
	
	AttachmentDetails findById(Long id);
	
}
