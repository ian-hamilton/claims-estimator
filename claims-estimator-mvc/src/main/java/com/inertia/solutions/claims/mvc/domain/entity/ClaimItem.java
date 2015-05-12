/**
 * 
 */
package com.inertia.solutions.claims.mvc.domain.entity;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
@JsonPropertyOrder({ "id", "claimItemName", "claimItemDesc", "totalAmount", 
	"removeAmount", "replaceAmount", "category", "sel", "defaultCalculation", "notes", "claimType" })
public class ClaimItem  {
	
	@Id
	@JsonProperty(value = "Id", index = 0, required = false)
	private String id;

	public String getId() {
		return id;
	}
	
	@NotNull
	@JsonProperty(value = "Claim_Item_Name", index = 1, required = true) 
	private String claimItemName;

	@NotNull
	@JsonProperty(value = "Item_Description", index = 2, required = true) 
	private String claimItemDesc;
	
	@NotNull
	@JsonProperty(value = "Total_Amount", index = 3, required = true)
	private Double totalAmount;
	
	@NotNull
	@JsonProperty(value = "Removal_Amount", index = 4, required = true)
	private Double removeAmount;
	
	@NotNull
	@JsonProperty(value = "Replace_Amount", index = 5, required = true) 
	private Double replaceAmount;
	
	@NotNull
	@JsonProperty(value = "Category", index = 6, required = true) 
	private String category;
	
	@JsonProperty(value = "Sel", index = 7, required = false) 
	String sel;
	
	@NotNull
	@JsonProperty(value = "Default_Calculation", index = 8, required = true) 
	String defaultCalculation;
	
	@JsonProperty(value = "Notes", index = 9, required = false) 
	String notes;
	
	@NotNull
	@JsonProperty(value = "Item_Type", index = 10, required = true) 
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
