/**
 * 
 */
package com.inertia.solutions.claims.mvc.app.calculator.command.impl;

import com.inertia.solutions.claims.mvc.app.calculator.command.OperatorCommand;
import com.inertia.solutions.spring.mvc.app.calculator.Calculator;


public class MultiplyCommand implements OperatorCommand {

	private Calculator calculator;
	
	public MultiplyCommand(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public Integer exec(Integer value1, Integer value2) {
		return calculator.multiply(value1, value2);
	}
}
