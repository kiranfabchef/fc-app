package com.fc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.app.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{

	Customer findByUserNameAndPassword(String userName, String password);
}
