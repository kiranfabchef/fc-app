package com.fc.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = FcTableNames.TABLE_REF_VENUE_DETAILS)
public class RefVenueDetails {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CAPACITY")
	private Long capacity;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "RATING")
	private String rating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "RefVenueDetails [id=" + id + ", capacity=" + capacity + ", address=" + address + ", rating=" + rating
				+ "]";
	}
	

}
