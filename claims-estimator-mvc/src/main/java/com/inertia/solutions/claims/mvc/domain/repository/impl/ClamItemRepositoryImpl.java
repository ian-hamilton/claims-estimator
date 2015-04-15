/**
 * 
 */
package com.inertia.solutions.claims.mvc.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;
import com.inertia.solutions.claims.mvc.domain.repository.ClaimItemRepository;

/**
 * @author ihamilto
 *
 */
@Repository
public class ClamItemRepositoryImpl implements ClaimItemRepository{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public <S extends ClaimItem> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClaimItem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClaimItem> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClaimItem> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClaimItem> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ClaimItem> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ClaimItem arg0) {
		mongoTemplate.remove(arg0);
	}

	@Override
	public void delete(Iterable<? extends ClaimItem> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<ClaimItem> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClaimItem findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends ClaimItem> S save(S arg0) {
		mongoTemplate.save(arg0);
		return (S) mongoTemplate.findById(arg0.getId(), ClaimItem.class);
	}
	
}
