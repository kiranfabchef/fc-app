package com.fc.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = FcTableNames.TABLE_CHEF)
public class Chef {
	
	@Id
	@Column(name = "CHEF_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "CHEF_FULL_NAME")
	private String chefFullName;
	
	@Column(name = "CHEF_NICK_NAME")
	private String chefNickName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "ZIP")
	private String zip;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "PRICE_UNITS")
	private Integer priceUntis;
	
	@Column(name = "PRICE_CURRENCY")
	private String priceCurrency;

	@Column(name = "PRICE_PER")
	private Character pricePerMeasure;
	
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
	
	@Column(name = "CHEF_AVAILABILITY_DAYS")
	private String chefAvailabilityDays;
	
	@Column(name = "CHEF_AVAILABILITY_SLOTS")
	private String chefAvailabilitySlots;
	
	@Column(name = "CHEF_FB_LINK")
	private String chefFbLink;
	
	@Column(name = "CHEF_TWITTER_LINK")
	private String chefTwitterLink;
	
	@Column(name = "CHEF_LINKEDIN_LINK")
	private String chefLinkedinLink;
	
/*	@OneToMany(cascade = CascadeType.ALL, mappedBy="chefId")
	@JsonManagedReference
	private List<ChefAvailability> chefAvailability;*/

	@OneToMany(cascade = CascadeType.ALL, mappedBy="chef")
	@JsonManagedReference
	private List<ChefCuisines> chefCuisines;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public String getChefFullName() {
		return chefFullName;
	}

	public void setChefFullName(String chefFullName) {
		this.chefFullName = chefFullName;
	}

	public String getChefNickName() {
		return chefNickName;
	}

	public void setChefNickName(String chefNickName) {
		this.chefNickName = chefNickName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPriceUntis() {
		return priceUntis;
	}

	public void setPriceUntis(Integer priceUntis) {
		this.priceUntis = priceUntis;
	}

	public String getPriceCurrency() {
		return priceCurrency;
	}

	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}

	public Character getPricePerMeasure() {
		return pricePerMeasure;
	}

	public void setPricePerMeasure(Character pricePerMeasure) {
		this.pricePerMeasure = pricePerMeasure;
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
	
	/*public List<ChefAvailability> getChefAvailability() {
		return chefAvailability;
	}

	public void setChefAvailability(List<ChefAvailability> chefAvailability) {
		this.chefAvailability = chefAvailability;
	}*/
	
	public String getChefAvailabilityDays() {
		return chefAvailabilityDays;
	}

	public void setChefAvailabilityDays(String chefAvailabilityDays) {
		this.chefAvailabilityDays = chefAvailabilityDays;
	}

	public String getChefAvailabilitySlots() {
		return chefAvailabilitySlots;
	}

	public void setChefAvailabilitySlots(String chefAvailabilitySlots) {
		this.chefAvailabilitySlots = chefAvailabilitySlots;
	}

	public String getChefFbLink() {
		return chefFbLink;
	}

	public void setChefFbLink(String chefFbLink) {
		this.chefFbLink = chefFbLink;
	}

	public String getChefTwitterLink() {
		return chefTwitterLink;
	}

	public void setChefTwitterLink(String chefTwitterLink) {
		this.chefTwitterLink = chefTwitterLink;
	}

	public String getChefLinkedinLink() {
		return chefLinkedinLink;
	}

	public void setChefLinkedinLink(String chefLinkedinLink) {
		this.chefLinkedinLink = chefLinkedinLink;
	}
	
	public List<ChefCuisines> getChefCuisines() {
		return chefCuisines;
	}

	public void setChefCuisines(List<ChefCuisines> chefCuisines) {
		this.chefCuisines = chefCuisines;
	}

	@Override
	public String toString() {
		return "Chef [id=" + id + ", userName=" + userName + ", password=" + password + ", chefFullName=" + chefFullName
				+ ", chefNickName=" + chefNickName + ", address=" + address + ", zip=" + zip + ", state=" + state
				+ ", phone=" + phone + ", priceUntis=" + priceUntis + ", priceCurrency=" + priceCurrency
				+ ", pricePerMeasure=" + pricePerMeasure + ", createdOn=" + createdOn + ", createdBy=" + createdBy
				+ ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + ", activeFlag=" + activeFlag
				+ ", chefAvailabilityDays=" + chefAvailabilityDays + ", chefAvailabilitySlots=" + chefAvailabilitySlots
				+ ", chefFbLink=" + chefFbLink + ", chefTwitterLink=" + chefTwitterLink + ", chefLinkedinLink="
				+ chefLinkedinLink + "]";
	}
	
}
