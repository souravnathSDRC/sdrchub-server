package com.sdrc.sdrchub.service;

import com.sdrc.sdrchub.domain.User;

public interface UserService {

	User findByUsername(String userName);
	
}
