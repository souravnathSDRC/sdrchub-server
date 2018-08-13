package com.sdrc.sdrchub.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_tbl",uniqueConstraints = @UniqueConstraint(columnNames="user_name"))
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column
	private String name;

	@Column(name = "user_name")
	private String userName;

	private String password;
	
	private String genpassword;

	@Column(name = "enabled", columnDefinition = "boolean DEFAULT true")
	private boolean enabled = true;
	
	@Column(name = "credentialexpired", columnDefinition = "boolean DEFAULT false")
	private boolean credentialexpired = false;

	@Column(name = "expired", columnDefinition = "boolean DEFAULT false")
	private boolean expired;

	@Column(name = "locked", columnDefinition = "boolean DEFAULT false")
	private boolean locked = false;


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isCredentialexpired() {
		return credentialexpired;
	}

	public void setCredentialexpired(boolean credentialexpired) {
		this.credentialexpired = credentialexpired;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}

	public String generatedEncodedPassword(String userName,String password) {
		MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("SHA1");
		return encoder.encodePassword(userName,password);
	}

	public String getGenpassword() {
		return genpassword;
	}

	public void setGenpassword(String genpassword) {
		this.genpassword = genpassword;
	}

	public User(){
		
	}
    
	public User(Integer userId) {
		this.userId = userId;
		
	}
}
