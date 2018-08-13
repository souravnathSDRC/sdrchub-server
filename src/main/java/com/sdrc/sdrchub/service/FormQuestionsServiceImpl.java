package com.sdrc.sdrchub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdrc.sdrchub.domain.FormQuestions;
import com.sdrc.sdrchub.repository.FormQuestionsRepository;

@Service
public class FormQuestionsServiceImpl implements FormQuestionsService {

	@Autowired
	FormQuestionsRepository formQuestionsRepository;
	
	@Override
	public List<FormQuestions> getAllQuestions() throws Exception {
		// TODO Auto-generated method stub
		return formQuestionsRepository.findAll();
	}
	
}
