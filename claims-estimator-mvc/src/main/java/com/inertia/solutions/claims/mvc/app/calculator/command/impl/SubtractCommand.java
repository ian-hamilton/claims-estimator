/**
 * 
 */
package com.inertia.solutions.claims.mvc.app.calculator.command.impl;

import com.inertia.solutions.claims.mvc.app.calculator.command.OperatorCommand;
import com.inertia.solutions.spring.mvc.app.calculator.Calculator;

/**
 * @author devl
 *
 */
public class SubtractCommand implements OperatorCommand{

	private Calculator calculator;
	
	public SubtractCommand(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public Integer exec(Integer value1, Integer value2) {
		return calculator.subtract(value1, value2);
	}
}
