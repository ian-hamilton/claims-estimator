package com.inertia.solutions.claims.mvc.web.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class OperatorModelTest {

	OperatorModel modelUnderTest = new OperatorModel();
	
	List<String> list = new ArrayList<String>(Arrays.asList("a"));
	
	@Test
	public void testConstructor() {
		List<String> result = modelUnderTest.getOperators();
		assertEquals(4, result.size());
	}
	
	@Test
	public void testSetterGetter() {
		modelUnderTest.setOperators(list);
		List<String> result = modelUnderTest.getOperators();
		assertEquals(1, result.size());
		assertEquals("a", result.get(0));
	}
}
