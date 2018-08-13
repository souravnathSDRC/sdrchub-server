package com.sdrc.sdrchub.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.RepositoryDefinition;

import com.sdrc.sdrchub.domain.User;

@RepositoryDefinition(idClass=Integer.class,domainClass=User.class)
public interface UserRepository  {

	@Cacheable("users")
	User findByUserName(String username);

}
