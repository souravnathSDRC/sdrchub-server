package com.sdrc.sdrchub.service;

import java.util.List;

import com.sdrc.sdrchub.domain.FormQuestions;

public interface FormQuestionsService {

	List<FormQuestions> getAllQuestions() throws Exception;
}
