package com.inertia.solutions.claims.mvc.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;


@Repository
public interface ClaimItemRepository extends MongoRepository<ClaimItem, String> {


}
