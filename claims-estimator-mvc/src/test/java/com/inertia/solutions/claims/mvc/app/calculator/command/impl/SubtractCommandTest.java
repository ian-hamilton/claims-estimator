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
public class SubtractCommandTest {
	
	@Mock
	Calculator calculator;
	
	SubtractCommand commandUnderTest;
	
	private final Integer value1 = new Integer(5);
	private final Integer value2 = new Integer(6);
	private final Integer result = new Integer(1);
	
	@Before
	public void setup() {
		commandUnderTest = new SubtractCommand(calculator);
		Mockito.when(calculator.subtract(value1, value2)).thenReturn(result);
	}
	
	@Test
	public void testExec() throws Exception {
		Integer result = commandUnderTest.exec(value1, value2);
		assertEquals(this.result, result);
	}
}
