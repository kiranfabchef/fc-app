package com.fc.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fc.app.model.RefPaymentMethods;
import com.fc.app.repository.RefPaymentMethodsRepository;
import com.fc.app.service.RefPaymentMethodsService;

@Service
public class RefPaymentMethodsServiceImpl implements RefPaymentMethodsService {
	
	@Autowired
	private RefPaymentMethodsRepository repo;

	@Override
	public List<RefPaymentMethods> getAllPaymentMethods() {
		return repo.findAll();
	}

	@Override
	public Optional<RefPaymentMethods> getPaymentMethodById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<RefPaymentMethods> getAllPaymentMethodsByExample(RefPaymentMethods example) {
		return repo.findAll(Example.of(example));
	}

	@Override
	public RefPaymentMethods save(RefPaymentMethods paymentMethod) {
		return repo.save(paymentMethod);
	}

	@Override
	public List<RefPaymentMethods> saveAll(Iterable<RefPaymentMethods> paymentMethodList) {
		return repo.saveAll(paymentMethodList);
	}

}
