package com.inertia.solutions.claims.mvc.app.calculator.command.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;

import com.inertia.solutions.claims.mvc.app.calculator.command.OperatorCommand;
import com.inertia.solutions.spring.mvc.app.calculator.Calculator;

@RunWith(MockitoJUnitRunner.class)
public class OperatorCommandInvokerTest {

	@Mock
	Calculator calculator;
	
	@InjectMocks
	OperatorCommandInvoker invokerUnderTest;
	
	@Before
	public void setup() {
		invokerUnderTest.init();
	}
	
	@Test
	public void testInvoke_Add() throws Exception {
		OperatorCommand command = invokerUnderTest.invoke("+");
		Assert.isInstanceOf(AddCommand.class, command);
	}
	
	@Test
	public void testInvoke_Subtract() throws Exception {
		OperatorCommand command = invokerUnderTest.invoke("-");
		Assert.isInstanceOf(SubtractCommand.class, command);
	}
	
	@Test
	public void testInvoke_Multiply() throws Exception {
		OperatorCommand command = invokerUnderTest.invoke("*");
		Assert.isInstanceOf(MultiplyCommand.class, command);
	}
	
	@Test
	public void testInvoke_Divide() throws Exception {
		OperatorCommand command = invokerUnderTest.invoke("/");
		Assert.isInstanceOf(DivideCommand.class, command);
	}
	
	@Test
	public void testInvoke_Null() throws Exception {
		OperatorCommand command = invokerUnderTest.invoke("a");
		Assert.isNull(command);
	}

}
