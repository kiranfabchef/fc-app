package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.Customer;

public interface CustomerService {

public List<Customer> getAllCustomers();
	
	public Optional<Customer> getCustomerById(Long id);
	
	public List<Customer> getAllCustomersByExample(Customer example);
	
	public Customer save(Customer Customer);
	
	public List<Customer> saveAll(Iterable<Customer> Customers);

	public Customer findByUserNamePassword(String userName, String password);
}
