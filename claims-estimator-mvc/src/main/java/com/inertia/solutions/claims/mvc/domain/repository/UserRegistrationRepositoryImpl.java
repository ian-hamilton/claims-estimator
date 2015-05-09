package com.inertia.solutions.claims.mvc.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inertia.solutions.claims.mvc.domain.entity.UserRegistration;

public interface UserRegistrationRepositoryImpl extends MongoRepository<UserRegistration, String>{
	
	@Query("{email : ?0}")
	public List<UserRegistration> getUserRegistrationByEmail(String email);

}
