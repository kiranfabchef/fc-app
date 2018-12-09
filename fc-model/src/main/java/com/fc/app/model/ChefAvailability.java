package com.fc.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = FcTableNames.TABLE_CHEF_AVAILABILITY)

public class ChefAvailability {

	@Id
	@Column(name = "CHEF_AVAILABILITY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chefAvailabilityId;
	
	@ManyToOne
	@JoinColumn(name = "CHEF_ID", nullable = false)
	@JsonBackReference
	private Chef chefId;
	
	@Column(name = "DATE")
	private Date date;
	
	@OneToOne
	@JoinColumn(name = "SLOT_ID")
	private ChefSlot slot;

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

	public Long getChefAvailabilityId() {
		return chefAvailabilityId;
	}

	public void setChefAvailabilityId(Long chefAvailabilityId) {
		this.chefAvailabilityId = chefAvailabilityId;
	}

	public Chef getChefId() {
		return chefId;
	}

	public void setChefId(Chef chefId) {
		this.chefId = chefId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public ChefSlot getSlot() {
		return slot;
	}

	public void setSlot(ChefSlot slot) {
		this.slot = slot;
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
		return "ChefAvailability [chefAvailabilityId=" + chefAvailabilityId + ", chefId=" + chefId + ", date=" + date
				+ ", slotId=" + slot + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn="
				+ updatedOn + ", updatedBy=" + updatedBy + ", activeFlag=" + activeFlag + "]";
	}
	
	
}
