/**
 * 
 */
package com.inertia.solutions.claims.mvc.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;
import com.inertia.solutions.claims.mvc.domain.repository.ClaimItemRepository;
import com.inertia.solutions.claims.mvc.domain.service.ClaimItemService;

/**
 * @author ihamilto
 *
 */
@Service
public class ClaimItemServiceImpl implements ClaimItemService {

	@Autowired
	ClaimItemRepository claimItemRepository;
	
	@Override
	public List<ClaimItem> findAll() {
		return claimItemRepository.findAll();
	}

	@Override
	public ClaimItem saveClaimItem(ClaimItem claimItem) {
		return claimItemRepository.save(claimItem);
	}

}
