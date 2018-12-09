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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = FcTableNames.TABLE_CHEF_CUISINE)
public class ChefCuisines {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CHEF_ID", nullable = false)
	@JsonBackReference
	private Chef chefId;

	@OneToOne
	@JoinColumn(name = "CUISINE_ID")
	private RefCuisine cuisine;

	@CreationTimestamp
	@Column(name = "CREATED_ON")
	private Date createdOn;
	
	@Column(name = "CREATED_BY")
	private String createdBy;

	public Chef getChefId() {
		return chefId;
	}

	public void setChefId(Chef chefId) {
		this.chefId = chefId;
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
		return "ChefCuisines [id=" + id + ", chefId=" + chefId + ", cuisine=" + cuisine + ", createdOn=" + createdOn
				+ ", createdBy=" + createdBy + "]";
	}
	
	
}
