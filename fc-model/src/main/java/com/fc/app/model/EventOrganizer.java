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
@Table(name = FcTableNames.TABLE_EVENT_ORGANIZER)*/
public class EventOrganizer {
	
    @Id
	@Column(name = "EVENT_ORGANIZER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eventOrganizerId;

	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ORGANIZER_NAME")
	private String organizerName;
	
	@Column(name = "NICK_NAME")
	private String nickName;
	
	@Column(name = "CUSINIS")
	private String cuisines;
	
	@Column(name = "EVENT_TYPE")
	private String eventTypes;
	
	@Column(name = "RECEIPES")
	private String receipes;
	
	@Column(name = "ZIP")
	private String zip;
	
	@Column(name = "FIXED_BUDGET")
	private Float fixedBudget;
	
	@Column(name = "HOURLY_CHARGES")
	private Float hourlyCharges;
  
  	@Column(name = "CREDIT_CARD")
	private Long creditCard;
  	
  	@Column(name = "DELIVERY_DATE")
	private Date deliveryDate;
	
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

	public Long getEventOrganizerId() {
		return eventOrganizerId;
	}

	public void setEventOrganizerId(Long eventOrganizerId) {
		this.eventOrganizerId = eventOrganizerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCuisines() {
		return cuisines;
	}

	public void setCuisines(String cuisines) {
		this.cuisines = cuisines;
	}

	public String getEventTypes() {
		return eventTypes;
	}

	public void setEventTypes(String eventTypes) {
		this.eventTypes = eventTypes;
	}

	public String getReceipes() {
		return receipes;
	}

	public void setReceipes(String receipes) {
		this.receipes = receipes;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Float getFixedBudget() {
		return fixedBudget;
	}

	public void setFixedBudget(Float fixedBudget) {
		this.fixedBudget = fixedBudget;
	}

	public Float getHourlyCharges() {
		return hourlyCharges;
	}

	public void setHourlyCharges(Float hourlyCharges) {
		this.hourlyCharges = hourlyCharges;
	}

	public Long getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(Long creditCard) {
		this.creditCard = creditCard;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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
		return "EventOrganizer [eventOrganizerId=" + eventOrganizerId + ", userName=" + userName + ", password="
				+ password + ", organizerName=" + organizerName + ", nickName=" + nickName + ", cuisines=" + cuisines
				+ ", eventTypes=" + eventTypes + ", receipes=" + receipes + ", zip=" + zip + ", fixedBudget="
				+ fixedBudget + ", hourlyCharges=" + hourlyCharges + ", creditCard=" + creditCard + ", deliveryDate="
				+ deliveryDate + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn=" + updatedOn
				+ ", updatedBy=" + updatedBy + ", activeFlag=" + activeFlag + "]";
	}
	
	
}
