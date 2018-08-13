package com.sdrc.sdrchub.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author Sourav Keshari Nath
 */
import javax.persistence.Transient;

import com.sdrc.sdrchub.models.FileModel;

@Entity
public class EntryDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "module_id")
	private Integer moduleId;
	
	@Column(name = "platform_id")
	private Integer platformId;

	@Column(name = "subject")
	private String subject;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "tags")
	private String tags;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "reference_links")
	private String referenceLinks;

	@Column(name = "video_links")
	private String videoLinks;
	
	@Column(name = "attached_document_path")
	private String attachedDocumentPath;


	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "is_live")
	private boolean isLive;
	
	@Transient
	private FileModel documents;
	
	@Transient
	private FileModel moduleName;
	
	@Transient
	private FileModel platformName;
	
	

	public FileModel getDocuments() {
		return documents;
	}

	public void setDocuments(FileModel documents) {
		this.documents = documents;
	}

	public FileModel getModuleName() {
		return moduleName;
	}

	public void setModuleName(FileModel moduleName) {
		this.moduleName = moduleName;
	}

	public FileModel getPlatformName() {
		return platformName;
	}

	public void setPlatformName(FileModel platformName) {
		this.platformName = platformName;
	}

	public String getVideoLinks() {
		return videoLinks;
	}

	public void setVideoLinks(String videoLinks) {
		this.videoLinks = videoLinks;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getReferenceLinks() {
		return referenceLinks;
	}

	public void setReferenceLinks(String referenceLinks) {
		this.referenceLinks = referenceLinks;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	
	public String getAttachedDocumentPath() {
		return attachedDocumentPath;
	}

	public void setAttachedDocumentPath(String attachedDocumentPath) {
		this.attachedDocumentPath = attachedDocumentPath;
	}
	
}
