package com.fc.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = FcTableNames.TABLE_REF_PACKAGE_TYPES)
public class RefPackageTypes {

	@Id
	@Column(name = "PACKAGE_TYPE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long packageTypeId;
}
