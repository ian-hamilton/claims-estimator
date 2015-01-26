package com.inertia.solutions.claims.mvc.app.calculator.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorImplTest {

	CalculatorImpl underTest;
	
	@Before
	public void setup() {
		underTest = new CalculatorImpl();
	}
	
	@Test
	public void testAdd() throws Exception {
		Integer result = underTest.add(3, 2);
		Assert.assertEquals(new Integer(5), result);
	}

	@Test
	public void testSubtract() throws Exception {
		Integer result = underTest.subtract(5, 3);
		Assert.assertEquals(new Integer(2), result);
	}

	@Test
	public void testMultiply() throws Exception {
		Integer result = underTest.multiply(5, 5);
		Assert.assertEquals(new Integer(25), result);
	}

	@Test
	public void testDivide() throws Exception {
		Integer result = underTest.divide(25, 5);
		Assert.assertEquals(new Integer(5), result);
	}

	
	
}
