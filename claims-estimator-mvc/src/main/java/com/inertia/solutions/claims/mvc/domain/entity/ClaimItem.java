/**
 * 
 */
package com.inertia.solutions.claims.mvc.domain.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ihamilto
 *
 */
@Document(collection = "claimItem")
public class ClaimItem extends AbstractDomain {
	
	/**
     */
	@NotNull
	private String claimItemName;

	/**
     */
	@NotNull
	private String ClaimItemDesc;

	/**
     */
	@NotNull
	private Double claimItemAmount;
	

	public String getClaimItemName() {
		return claimItemName;
	}



	public void setClaimItemName(String claimItemName) {
		this.claimItemName = claimItemName;
	}



	public String getClaimItemDesc() {
		return ClaimItemDesc;
	}



	public void setClaimItemDesc(String claimItemDesc) {
		ClaimItemDesc = claimItemDesc;
	}



	public Double getClaimItemAmount() {
		return claimItemAmount;
	}



	public void setClaimItemAmount(Double claimItemAmount) {
		this.claimItemAmount = claimItemAmount;
	}



	@Override
	public String toString() {
		return "ClaimItem [claimItemName=" + claimItemName + ", ClaimItemDesc="
				+ ClaimItemDesc + ", claimItemAmount=" + claimItemAmount
				+ ", getId()=" + getId() + "]";
	}

}
