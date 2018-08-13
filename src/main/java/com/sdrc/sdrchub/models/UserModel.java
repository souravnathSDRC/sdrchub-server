package com.sdrc.sdrchub.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * 
 * @author Laxman
 *
 */

@JsonAutoDetect
public class UserModel extends User {

	private static final long serialVersionUID = 3070385867750194519L;

	// add all extra required details for your application
//	@JsonIgnore
	private long userLoginMetaId;

	

	public UserModel(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.userLoginMetaId = userLoginMetaId;
	}

	public long getUserLoginMetaId() {
		return userLoginMetaId;
	}

	public void setUserLoginMetaId(long userLoginMetaId) {
		this.userLoginMetaId = userLoginMetaId;
	}

	

	
	
	

	

}
