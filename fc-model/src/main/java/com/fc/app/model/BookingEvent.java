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
@Table(name = FcTableNames.TABLE_BOOKING_EVENT)*/
public class BookingEvent {

	@Id
	@Column(name = "BOOKING_EVENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingEventId;

	@Column(name = "BOOKING_ID")
	private Long bookingId;

	@Column(name = "EVENT_NUMBER")
	private String eventNumber;

	@Column(name = "EVENT_TYPE")
	private String eventType;

	@Column(name = "EVENT_DATE")
	private Date eventDate;

	@Column(name = "EVENT_START_TIME")
	private Date eventStartDate;

	@Column(name = "EVENT_END_TIME")
	private Date eventEndDate;

	@Column(name = "EVENT_CAPACITY")
	private Long eventCapacity;

	@Column(name = "EVENT_RATING")
	private String eventRating;

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

	public Long getBookingEventId() {
		return bookingEventId;
	}

	public void setBookingEventId(Long bookingEventId) {
		this.bookingEventId = bookingEventId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getEventNumber() {
		return eventNumber;
	}

	public void setEventNumber(String eventNumber) {
		this.eventNumber = eventNumber;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public Long getEventCapacity() {
		return eventCapacity;
	}

	public void setEventCapacity(Long eventCapacity) {
		this.eventCapacity = eventCapacity;
	}

	public String getEventRating() {
		return eventRating;
	}

	public void setEventRating(String eventRating) {
		this.eventRating = eventRating;
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
		return "BookingEvent [bookingEventId=" + bookingEventId + ", bookingId=" + bookingId + ", eventNumber="
				+ eventNumber + ", eventType=" + eventType + ", eventDate=" + eventDate + ", eventStartDate="
				+ eventStartDate + ", eventEndDate=" + eventEndDate + ", eventCapacity=" + eventCapacity
				+ ", eventRating=" + eventRating + ", createdOn=" + createdOn + ", createdBy=" + createdBy
				+ ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + ", activeFlag=" + activeFlag + "]";
	}
	
}
