package com.fc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.app.model.Chef;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long>{

	Chef findByUserNameAndPassword(String userName, String password);

}
