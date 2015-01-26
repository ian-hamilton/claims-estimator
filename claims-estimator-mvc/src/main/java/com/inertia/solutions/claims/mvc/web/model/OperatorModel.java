package com.inertia.solutions.claims.mvc.web.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperatorModel {

	List<String> operators;

	public OperatorModel() {
		operators = new ArrayList<String>(Arrays.asList("+","-","*","/"));
	}
	
	public List<String> getOperators() {
		return operators;
	}

	public void setOperators(List<String> operators) {
		this.operators = operators;
	}
	
}
