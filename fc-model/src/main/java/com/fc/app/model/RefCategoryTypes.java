package com.fc.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = FcTableNames.TABLE_REF_CATEGORY_TYPES)
public class RefCategoryTypes {
	
	@Id
	@Column(name = "REF_CATEGORY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long refCategoryId;
	
	@Column(name = "CATEGORY_TYPE")
	private String categoryType;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATED_ON")
	@CreationTimestamp 
	private Date createdOn;

	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDATED_ON")
	@UpdateTimestamp 
	private Date updatedOn;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "ACTIVE_FLAG")
	private Character activeFlag;

	public Long getRefCategoryId() {
		return refCategoryId;
	}

	public void setRefCategoryId(Long refCategoryId) {
		this.refCategoryId = refCategoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Character getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Override
	public String toString() {
		return "RefCategoryTypes [refCategoryId=" + refCategoryId + ", categoryType=" + categoryType + ", description="
				+ description + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn=" + updatedOn
				+ ", updatedBy=" + updatedBy + ", activeFlag=" + activeFlag + "]";
	}

	
}
