package com.sdrc.sdrchub.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * @author Laxman(laxman@sdrc.co.in)
*/

@Entity
public class AttachmentDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_pk")
	private Integer id;

	@Column(name = "type_id_fk")
	private Integer typeId;
	
	@Column(name = "ref_entry_id_fk")
	private Integer referenceEntryId;
	
	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;
	
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getReferenceEntryId() {
		return referenceEntryId;
	}

	public void setReferenceEntryId(Integer referenceEntryId) {
		this.referenceEntryId = referenceEntryId;
	}

	@Column(name = "name")
	private String name;

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
