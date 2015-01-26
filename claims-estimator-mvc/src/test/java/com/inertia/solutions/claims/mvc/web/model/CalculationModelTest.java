package com.inertia.solutions.claims.mvc.web.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CalculationModelTest {

	private final Integer value1 = new Integer(5);
	private final Integer value2 = new Integer(6);
	private static final String ADD = "+";
	
	@Test
	public void testGetterSetter() {
		CalculationModel modelUnderTest = new CalculationModel();
		modelUnderTest.setOperator(ADD);
		modelUnderTest.setValue1(value1.toString());
		modelUnderTest.setValue2(value2.toString());
		
		assertEquals(ADD, modelUnderTest.getOperator());
		assertEquals(value1.toString(), modelUnderTest.getValue1());
		assertEquals(value2.toString(), modelUnderTest.getValue2());
	}
	
}
