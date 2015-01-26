package com.inertia.solutions.claims.mvc.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class CalculationModel {

	private String value1;
	
	private String value2;
	
	private String operator;

	@NotNull(message="Value 1 must not be empty")
	@NotBlank(message="Value 1 must not be empty")
	@Pattern(regexp="^(\\+|-)?\\d+$", message="Value 1 must be a valid integer")
	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	@NotNull(message="Value 2 must not be empty")
	@NotBlank(message="Value 2 must not be empty")
	@Pattern(regexp="^(\\+|-)?\\d+$", message="Value 2 must be a valid integer")
	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	@NotNull(message="Operator must not be empty")
	@NotBlank(message="Operator must not be empty")
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}	
}
