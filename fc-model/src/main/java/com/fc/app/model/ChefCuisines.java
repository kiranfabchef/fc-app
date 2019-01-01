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
@Table(name = FcTableNames.TABLE_CHEF_CUISINE)
public class ChefCuisines {
	
  @Id
	@Column(name = "CHEF_CUISINE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CHEF_ID", nullable = false)
	@JsonBackReference
	private Chef chef;

	@OneToOne
	@JoinColumn(name = "CUISINE_ID")
	private RefCuisine cuisine;

	@CreationTimestamp
	@Column(name = "CREATED_ON")
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

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
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

	public void setId(Long id) {
		this.id = id;
	}

	public RefCuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(RefCuisine cuisine) {
		this.cuisine = cuisine;
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

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ChefCuisines [id=" + id + ", chef=" + chef + ", cuisine=" + cuisine + ", createdOn=" + createdOn
				+ ", createdBy=" + createdBy + ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + ", activeFlag="
				+ activeFlag + "]";
	}
	
	
}
