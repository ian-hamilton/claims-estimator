/**
 * 
 */
package com.inertia.solutions.claims.mvc.domain.service;

import java.util.List;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;

/**
 * @author ihamilto
 *
 */
public interface ClaimItemService {
	
	public List<ClaimItem> findAllClaimItems();
	
	public ClaimItem saveClaimItem(ClaimItem claimItem);
	
	public void deleteClaimItem(ClaimItem claimItem);
	
	public void deleteClaimItem(String id);

	public ClaimItem findClaimItemById(String id);
}
