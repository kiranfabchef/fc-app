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

//@Entity
//@Table(name = FcTableNames.TABLE_CUSTOMER_BOOKING)
public class CustomerBooking {

  	@Id
	@Column(name = "BOOKING_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookingId;

	@Column(name = "CUSTOMER_ID")
	private Long customerId;
	
	@Column(name = "BOOKING_DATE")
	private Date bookingDate;
	
	@Column(name = "BOOKING_STATUS")
	private Long bookingStatus;
	
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

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Long getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Long bookingStatus) {
		this.bookingStatus = bookingStatus;
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
		return "CustomerBooking [bookingId=" + bookingId + ", customerId=" + customerId + ", bookingDate=" + bookingDate
				+ ", bookingStatus=" + bookingStatus + ", createdOn=" + createdOn + ", createdBy=" + createdBy
				+ ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + ", activeFlag=" + activeFlag + "]";
	}
	

}
