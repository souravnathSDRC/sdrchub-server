package com.sdrc.sdrchub.domain;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Laxman(laxman@sdrc.co.in)
 */

@Entity
public class TypeDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_pk")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "type_level_id")
	private Integer typeLevelId;
	
	@Column(name = "type_level_name")
	private String typeLevelName;
	
	@Column(name = "type_order")
	private Integer typeOrder;
	
	
	public Integer getTypeOrder() {
		return typeOrder;
	}

	public void setTypeOrder(Integer typeOrder) {
		this.typeOrder = typeOrder;
	}

	public Integer getTypeLevelId() {
		return typeLevelId;
	}

	public void setTypeLevelId(Integer typeLevelId) {
		this.typeLevelId = typeLevelId;
	}

	public String getTypeLevelName() {
		return typeLevelName;
	}

	public void setTypeLevelName(String typeLevelName) {
		this.typeLevelName = typeLevelName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	

}
