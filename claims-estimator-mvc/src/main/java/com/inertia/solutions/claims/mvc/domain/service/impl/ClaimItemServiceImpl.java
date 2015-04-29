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
 * Using JRE 1.7.0_75
 * 
 * The Class ClaimItemServiceImpl is the implementation for the basic service 
 * that updates items. Notice the injection of the repository dependency. This is 
 * important since this will provide the abstraction layer between all items, though
 * for this exercise it is thin.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
@Service
public class ClaimItemServiceImpl implements ClaimItemService {

	/** The claim item repository. */
	@Autowired
	ClaimItemRepositoryImpl claimItemRepository;
	
	/* (non-Javadoc)
	 * @see com.inertia.solutions.claims.mvc.domain.service.ClaimItemService#findAllClaimItems()
	 */
	@Override
	public List<ClaimItem> findAllClaimItems(String claimType) {
		return claimItemRepository.findAllByType(claimType);
	}

	/* (non-Javadoc)
	 * @see com.inertia.solutions.claims.mvc.domain.service.ClaimItemService#saveClaimItem(com.inertia.solutions.claims.mvc.domain.entity.ClaimItem)
	 */
	@Override
	public ClaimItem saveClaimItem(ClaimItem claimItem) {
		return claimItemRepository.save(claimItem);
	}

	/* (non-Javadoc)
	 * @see com.inertia.solutions.claims.mvc.domain.service.ClaimItemService#deleteClaimItem(com.inertia.solutions.claims.mvc.domain.entity.ClaimItem)
	 */
	@Override
	public void deleteClaimItem(ClaimItem claimItem) {
		claimItemRepository.delete(claimItem);
	}

	/* (non-Javadoc)
	 * @see com.inertia.solutions.claims.mvc.domain.service.ClaimItemService#deleteClaimItem(java.lang.String)
	 */
	@Override
	public void deleteClaimItem(String id) {
		claimItemRepository.delete(id);		
	}

}
