package com.fc.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = FcTableNames.TABLE_REF_PAYMENT_METHODS)
public class RefPaymentMethods {

	@Id
	@Column(name = "PAYMENT_METHOD_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long packageMethodId;
}
