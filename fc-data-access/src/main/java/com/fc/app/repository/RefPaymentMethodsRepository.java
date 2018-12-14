package com.fc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.app.model.RefPaymentMethods;

@Repository
public interface RefPaymentMethodsRepository extends JpaRepository<RefPaymentMethods, Long>{

}
