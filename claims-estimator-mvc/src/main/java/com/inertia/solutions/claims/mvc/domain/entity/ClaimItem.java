/**
 * 
 */
package com.inertia.solutions.claims.mvc.domain.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ian Hamilton. Basic Bean (Pojo) 
 *
 *  {
     "type": "object",
     "id": "urn:jsonschema:com:inertia:solutions:claims:mvc:domain:entity:ClaimItem",
     "properties": {
         "defaultCalculation": {
             "type": "string"
         },
         "claimItemDesc": {
             "type": "string"
         },
         "id": {
             "type": "string"
         },
         "removeAmount": {
             "type": "number"
         },
         "claimType": {
             "type": "string"
         },
         "replaceAmount": {
             "type": "number"
         },
         "category": {
             "type": "string"
         },
         "totalAmount": {
             "type": "number"
         },
         "notes": {
             "type": "string"
         },
         "sel": {
             "type": "string"
         },
         "claimItemName": {
             "type": "string"
         }
     }
 }
 *
 *
 */
@Document(collection = "claimItem")
public class ClaimItem  {
	
	@Id
	private String id;

	public String getId() {
		return id;
	}
	
	@NotNull
	private String claimItemName;

	@NotNull
	private String claimItemDesc;
	
	@NotNull
	private Double totalAmount;
	
	@NotNull
	private Double removeAmount;
	
	@NotNull
	private Double replaceAmount;
	
	@NotNull
	private String category;
	
	@NotNull 
	String sel;
	
	@NotNull
	String defaultCalculation;
	
	String notes;
	
	@NotNull
	String claimType;

	public String getClaimItemName() {
		return claimItemName;
	}

	public void setClaimItemName(String claimItemName) {
		this.claimItemName = claimItemName;
	}

	public String getClaimItemDesc() {
		return claimItemDesc;
	}

	public void setClaimItemDesc(String claimItemDesc) {
		this.claimItemDesc = claimItemDesc;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getRemoveAmount() {
		return removeAmount;
	}

	public void setRemoveAmount(Double removeAmount) {
		this.removeAmount = removeAmount;
	}

	public Double getReplaceAmount() {
		return replaceAmount;
	}

	public void setReplaceAmount(Double replaceAmount) {
		this.replaceAmount = replaceAmount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getDefaultCalculation() {
		return defaultCalculation;
	}

	public void setDefaultCalculation(String defaultCalculation) {
		this.defaultCalculation = defaultCalculation;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, null, true);
	}
	
	
	
}
