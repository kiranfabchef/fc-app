package com.fc.app.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fc.app.FcApiErrorResponse;
import com.fc.app.model.Customer;
import com.fc.app.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
@Api(tags={ "customer" }, description="Operations pertaining to customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "Create a customer", response = Customer.class)
	@FcApiErrorResponse
	@RequestMapping(path="/", method=RequestMethod.POST)
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		ResponseEntity<Customer> response = null;
		Customer customerCreated = customerService.save(customer);
		response = new ResponseEntity<>(customerCreated, HttpStatus.OK);
		return response;
	}
	
	@ApiOperation(value = "Update the customer", response = Customer.class)
	@FcApiErrorResponse
	@RequestMapping(path="/", method=RequestMethod.PUT)
	public ResponseEntity<Customer> update(@RequestBody Customer customer) {
		ResponseEntity<Customer> response = null;
		Customer customerModified = customerService.save(customer);
		response = new ResponseEntity<>(customerModified, HttpStatus.OK);
		return response;
	}
	
	@ApiOperation(value = "Fetch the customer by id", response = Customer.class)
	@FcApiErrorResponse
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
		ResponseEntity<Customer> response = null;
		Customer customer = null;
		Optional<Customer> customerOptional = customerService.getCustomerById(id);
	    if(customerOptional.isPresent()) {
	    	customer = customerOptional.get();
	    }
		response = new ResponseEntity<>(customer, HttpStatus.OK);
		return response;
	}
	
	@ApiOperation(value = "Fetch the list of customers", response = Iterable.class)
	@FcApiErrorResponse
	@RequestMapping(path="/fetch-all", method=RequestMethod.GET)
	public ResponseEntity<List<Customer>> fetchAllCustomers() {
		ResponseEntity<List<Customer>> response = null;
		List<Customer> customerList = null;
		customerList = customerService.getAllCustomers();
		response = new ResponseEntity<>(customerList, HttpStatus.OK);
		return response;
	}
	
	@ApiOperation(value = "Fetch the list of customers for the given criteria", response = Iterable.class)
	@FcApiErrorResponse
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public ResponseEntity<List<Customer>> fetchAllCustomersByExample(@RequestBody Customer customer) {
		ResponseEntity<List<Customer>> response = null;
		List<Customer> customerList = customerService.getAllCustomersByExample(customer);
		response = new ResponseEntity<>(customerList, HttpStatus.OK);
		return response;
	}
}
