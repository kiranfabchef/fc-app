package com.fc.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/*@Entity
@Table(name = FcTableNames.TABLE_CUSTOMER_PAYMENT_METHODS)*/
public class CustomerPaymentMethods {

	@Id
	@Column(name = "CUSTOMER_PAYMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerPaymentId;

	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@Column(name = "PAYMENT_METHOD_ID")
	private Long paymentMethodId;

	@Column(name = "CARD_NUMBER")
	private String cardNumber;

	@Column(name = "CARD_EXPIRY")
	private Date cardExpiry;

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

	public Long getCustomerPaymentId() {
		return customerPaymentId;
	}

	public void setCustomerPaymentId(Long customerPaymentId) {
		this.customerPaymentId = customerPaymentId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
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
		return "CustomerPaymentMethods [customerPaymentId=" + customerPaymentId + ", customerId=" + customerId
				+ ", paymentMethodId=" + paymentMethodId + ", cardNumber=" + cardNumber + ", cardExpiry=" + cardExpiry
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn=" + updatedOn + ", updatedBy="
				+ updatedBy + ", activeFlag=" + activeFlag + "]";
	}
	
	

}
