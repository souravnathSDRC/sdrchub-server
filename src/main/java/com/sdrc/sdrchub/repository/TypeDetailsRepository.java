package com.sdrc.sdrchub.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import com.sdrc.sdrchub.domain.TypeDetails;

@RepositoryDefinition(idClass=Integer.class,domainClass=TypeDetails.class)
public interface TypeDetailsRepository {

//	@Transactional
//	List<TypeDetails> findByTypeLevelId(List<Integer> typeLevelId);

	@Query(value="select td.* from type_details td where td.type_level_id in (:list)", nativeQuery=true)
	List<TypeDetails> getTypeLevelId(@Param("list") List<Integer> list);
}
