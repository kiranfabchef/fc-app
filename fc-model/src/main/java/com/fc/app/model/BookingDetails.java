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

/*@Entity
@Table(name = FcTableNames.TABLE_BOOKING_DETAILS)*/
public class BookingDetails {
	
	@Id
	@Column(name = "BOOKING_DETAILS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingDetailsId;
	
	@Column(name = "BOOKING_ID")
	private Long bookingId;
	
	@Column(name = "CHEF_ID")
	private Long chefId;
	
	@Column(name = "CHEF_CUISINE_ID")
	private Long chefCuisineId;
	
	@Column(name = "PACKAGE_TYPE_ID")
	private Long packageTypeId;
	
	@Column(name = "EVENT_VENUE_ID")
	private Long eventVenueId;
	
	@Column(name = "EVENT_ORGANIZER_ID")
	private Long eventOrganzerId;

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

	public Long getBookingDetailsId() {
		return bookingDetailsId;
	}

	public void setBookingDetailsId(Long bookingDetailsId) {
		this.bookingDetailsId = bookingDetailsId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getChefId() {
		return chefId;
	}

	public void setChefId(Long chefId) {
		this.chefId = chefId;
	}

	public Long getChefCuisineId() {
		return chefCuisineId;
	}

	public void setChefCuisineId(Long chefCuisineId) {
		this.chefCuisineId = chefCuisineId;
	}

	public Long getPackageTypeId() {
		return packageTypeId;
	}

	public void setPackageTypeId(Long packageTypeId) {
		this.packageTypeId = packageTypeId;
	}

	public Long getEventVenueId() {
		return eventVenueId;
	}

	public void setEventVenueId(Long eventVenueId) {
		this.eventVenueId = eventVenueId;
	}

	public Long getEventOrganzerId() {
		return eventOrganzerId;
	}

	public void setEventOrganzerId(Long eventOrganzerId) {
		this.eventOrganzerId = eventOrganzerId;
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
		return "BookingDetails [bookingDetailsId=" + bookingDetailsId + ", bookingId=" + bookingId + ", chefId="
				+ chefId + ", chefCuisineId=" + chefCuisineId + ", packageTypeId=" + packageTypeId + ", eventVenueId="
				+ eventVenueId + ", eventOrganzerId=" + eventOrganzerId + ", createdOn=" + createdOn + ", createdBy="
				+ createdBy + ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + ", activeFlag=" + activeFlag
				+ "]";
	}
	
	
}
