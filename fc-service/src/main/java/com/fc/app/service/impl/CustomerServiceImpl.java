package com.fc.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fc.app.model.Customer;
import com.fc.app.repository.CustomerRepository;
import com.fc.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repo;

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<Customer> getAllCustomersByExample(Customer example) {
		return repo.findAll(Example.of(example));
	}

	@Override
	public Customer save(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public List<Customer> saveAll(Iterable<Customer> customers) {
		return repo.saveAll(customers);
	}

	@Override
	public Customer findByUserNamePassword(String userName, String password) {
		return repo.findByUserNameAndPassword(userName, password);
	}

}
