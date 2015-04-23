/**
 * 
 */
package com.inertia.solutions.claims.mvc.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;
import com.inertia.solutions.claims.mvc.domain.repository.ClaimItemRepositoryImpl;
import com.inertia.solutions.claims.mvc.domain.service.ClaimItemService;

/**
 * @author ihamilto
 *
 */
@Service
public class ClaimItemServiceImpl implements ClaimItemService {

	@Autowired
	ClaimItemRepositoryImpl claimItemRepository;
	
	@Override
	public List<ClaimItem> findAllClaimItems() {
		return claimItemRepository.findAll();
	}

	@Override
	public ClaimItem saveClaimItem(ClaimItem claimItem) {
		return claimItemRepository.save(claimItem);
	}

	@Override
	public void deleteClaimItem(ClaimItem claimItem) {
		claimItemRepository.delete(claimItem);
	}

	@Override
	public void deleteClaimItem(String id) {
		claimItemRepository.delete(id);		
	}

	@Override
	public ClaimItem findClaimItemById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
