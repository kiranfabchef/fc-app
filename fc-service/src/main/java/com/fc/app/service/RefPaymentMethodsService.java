package com.fc.app.service;

import java.util.List;
import java.util.Optional;

import com.fc.app.model.RefPaymentMethods;

public interface RefPaymentMethodsService {

	public List<RefPaymentMethods> getAllPaymentMethods();
	
	public Optional<RefPaymentMethods> getPaymentMethodById(Long id);
	
	public List<RefPaymentMethods> getAllPaymentMethodsByExample(RefPaymentMethods example);
	
	public RefPaymentMethods save(RefPaymentMethods paymentMethod);
	
	public List<RefPaymentMethods> saveAll(Iterable<RefPaymentMethods> paymentMethodList);
}
