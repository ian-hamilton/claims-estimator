/**
 * 
 */
package com.inertia.solutions.claims.mvc.domain.entity;

import org.springframework.data.annotation.Id;

/**
 * @author ihamilto
 *
 */
public abstract class AbstractDomain {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AbstractDomain [id=" + id + "]";
	}
	
}
