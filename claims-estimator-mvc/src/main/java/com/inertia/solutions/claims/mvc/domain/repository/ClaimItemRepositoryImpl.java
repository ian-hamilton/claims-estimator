package com.inertia.solutions.claims.mvc.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;


public interface ClaimItemRepositoryImpl extends MongoRepository<ClaimItem, String> {

	
}
