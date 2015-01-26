package com.inertia.solutions.claims.mvc.app.calculator.impl;

import org.springframework.stereotype.Service;

import com.inertia.solutions.spring.mvc.app.calculator.Calculator;

@Service
public class CalculatorImpl implements Calculator{

	public Integer add(Integer value1, Integer value2) {
		return value1 + value2;
	}

	public Integer subtract(Integer value1, Integer value2) {
		return value1 - value2;
	}

	public Integer multiply(Integer value1, Integer value2) {
		return value1 * value2;
	}

	public Integer divide(Integer value1, Integer value2) {
		return value1 / value2;
	}

}
