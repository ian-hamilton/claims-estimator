package com.inertia.solutions.claims.mvc.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;


/**
 * Using JRE 1.7.0_75
 * 
 * The Interface ClaimItemRepositoryImpl which is interesting since it wires into
 * a class since it is scanned by the mongo context. This is why I have used the
 * "impl" postfix. This will provide all "overriden" implementation functions. Plus 
 * a couple of other function abstractions.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
public interface ClaimItemRepositoryImpl extends MongoRepository<ClaimItem, String> {

	@Query("{claimType : ?0 }")
	public List<ClaimItem> findAllByType(String claimType);
}
