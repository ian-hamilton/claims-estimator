/**
 * 
 */
package com.inertia.solutions.claims.mvc.domain.service;

import java.util.List;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;

/**
 * Using JRE 1.7.0_75
 * 
 * The Interface ClaimItemService. This service is an abstraction between the data
 * repository and the end front end (probably controller).
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
public interface ClaimItemService {
	
	/**
	 * Find all items.
	 *
	 * @return the list of Items returned
	 */
	public List<ClaimItem> findAllClaimItems(String claimType);
	
	/**
	 * Save claim item.
	 *
	 * @param claimItem the claim item
	 * @return the claim item
	 */
	public ClaimItem saveClaimItem(ClaimItem claimItem);
	
	/**
	 * Delete claim item.
	 *
	 * @param claimItem the claim item
	 */
	public void deleteClaimItem(ClaimItem claimItem);
	
	/**
	 * Delete claim item.
	 *
	 * @param id the id
	 */
	public void deleteClaimItem(String id);

}
