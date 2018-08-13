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
	
	@Column(name = "ref_entry_id_fk")
	private Integer referenceEntryId;
	
	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;
	
	@Column(name = "file_path")
	private String filePath;
	
	@Column(name = "doc_name")
	private String documentName;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@Column(name = "is_attached")
	private boolean isAttached;
	
	
	
	

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isAttached() {
		return isAttached;
	}

	public void setAttached(boolean isAttached) {
		this.isAttached = isAttached;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

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
