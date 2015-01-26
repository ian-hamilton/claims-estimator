package com.inertia.solutions.claims.mvc.app.calculator.command.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.mvc.app.calculator.Calculator;

@RunWith(MockitoJUnitRunner.class)
public class DivideCommandTest {

	@Mock
	Calculator calculator;
	
	DivideCommand commandUnderTest;
	
	private final Integer value1 = new Integer(5);
	private final Integer value2 = new Integer(6);
	private final Integer result = new Integer(1);
	
	@Before
	public void setup() {
		commandUnderTest = new DivideCommand(calculator);
		Mockito.when(calculator.divide(value1, value2)).thenReturn(result);
	}
	
	@Test
	public void testExec() throws Exception {
		Integer result = commandUnderTest.exec(value1, value2);
		assertEquals(this.result, result);
	}
}
