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
@Table(name = FcTableNames.TABLE_EVENT_VENUE)*/
public class EventVenue {

	@Id
	@Column(name = "EVENT_VENUE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eventVenueId;
	
	@Column(name = "EVENT_ID")
	private Long eventId;
	
	@Column(name = "VENUE_ID")
	private Long venueId;
	
	@Column(name = "VENUE_RATING")
	private String venueRating;
	
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

	public Long getEventVenueId() {
		return eventVenueId;
	}

	public void setEventVenueId(Long eventVenueId) {
		this.eventVenueId = eventVenueId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getVenueId() {
		return venueId;
	}

	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}

	public String getVenueRating() {
		return venueRating;
	}

	public void setVenueRating(String venueRating) {
		this.venueRating = venueRating;
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
		return "EventVenue [eventVenueId=" + eventVenueId + ", eventId=" + eventId + ", venueId=" + venueId
				+ ", venueRating=" + venueRating + ", createdOn=" + createdOn + ", createdBy=" + createdBy
				+ ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + ", activeFlag=" + activeFlag + "]";
	}
	
	
}
