package com.fc.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = FcTableNames.TABLE_REF_STATICDATA)
public class RefStaticData {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "MNEMO")
	private String mnemo;

	@Column(name = "LABEL")
	private String label;

	@OneToOne
	@JoinColumn(name = "CATEGORY")
	private RefCategoryTypes category;

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

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getMnemo() {
		return mnemo;
	}

	public void setMnemo(String mnemo) {
		this.mnemo = mnemo;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public RefCategoryTypes getCategory() {
		return category;
	}

	public void setCategory(RefCategoryTypes category) {
		this.category = category;
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
		return "RefStaticData [Id=" + Id + ", mnemo=" + mnemo + ", label=" + label + ", category=" + category
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn=" + updatedOn + ", updatedBy="
				+ updatedBy + ", activeFlag=" + activeFlag + "]";
	}
	
	
}
