package com.sdrc.sdrchub.repository;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import com.sdrc.sdrchub.domain.FormQuestions;

@RepositoryDefinition(idClass=Integer.class,domainClass=FormQuestions.class)
public interface FormQuestionsRepository {

	List<FormQuestions> findAll();
}
