package com.fc.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = FcTableNames.TABLE_CUISINE)
public class Cuisine {

	@Id
	@Column(name = "CUISINE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cuisineId;
	
	@Column(name = "CUISINE_NAME")
	private String cuisineName;
	
	@Column(name = "CUISINE_TYPE")
	private String cuisineType;
	
	@Column(name = "CUISINE_DESCRIPTION")
	private String cuisineDescription;
	
	@CreationTimestamp
	@Column(name = "CUISINE_CREATION_DATE")
	private Date cuisineCreatedOn;
	
	@Column(name = "CUISINE_CREATED_BY")
	private String cuisineCreatedBy;

	public Long getCuisineId() {
		return cuisineId;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getCuisineDescription() {
		return cuisineDescription;
	}

	public void setCuisineDescription(String cuisineDescription) {
		this.cuisineDescription = cuisineDescription;
	}

	public Date getCuisineCreatedOn() {
		return cuisineCreatedOn;
	}

	public void setCuisineCreatedOn(Date cuisineCreatedOn) {
		this.cuisineCreatedOn = cuisineCreatedOn;
	}

	public String getCuisineCreatedBy() {
		return cuisineCreatedBy;
	}

	public void setCuisineCreatedBy(String cuisineCreatedBy) {
		this.cuisineCreatedBy = cuisineCreatedBy;
	}

	public String getCuisineName() {
		return cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	@Override
	public String toString() {
		return "Cuisine [cuisineId=" + cuisineId + ", cuisineName=" + cuisineName + ", cuisineType=" + cuisineType
				+ ", cuisineDescription=" + cuisineDescription + ", cuisineCreatedOn=" + cuisineCreatedOn
				+ ", cuisineCreatedBy=" + cuisineCreatedBy + "]";
	}
	
	
}
