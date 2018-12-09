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
@Table(name = FcTableNames.TABLE_REF_CHEF_SLOTS)
public class ChefSlot {

	@Id
	@Column(name = "SLOT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slotId;

	@Column(name = "SLOT")
	private String slot;

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

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
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
		return "ChefSlots [slotId=" + slotId + ", slot=" + slot + ", createdOn=" + createdOn + ", createdBy="
				+ createdBy + ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + ", activeFlag=" + activeFlag
				+ "]";
	}
	
	
}
