package com.inertia.solutions.claims.mvc.app.calculator.command.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inertia.solutions.claims.mvc.app.calculator.command.CommandInvoker;
import com.inertia.solutions.claims.mvc.app.calculator.command.OperatorCommand;
import com.inertia.solutions.spring.mvc.app.calculator.Calculator;

@Component
public class OperatorCommandInvoker implements CommandInvoker<String, OperatorCommand>{

	@Autowired
	Calculator calculator;
	
	Map<String, OperatorCommand> commandMap;
	
	@PostConstruct
	public void init() {
		commandMap = new HashMap<String, OperatorCommand>();
		commandMap.put("+", new AddCommand(calculator));
		commandMap.put("-", new SubtractCommand(calculator));
		commandMap.put("*", new MultiplyCommand(calculator));
		commandMap.put("/", new DivideCommand(calculator));
	}
	
	@Override
	public OperatorCommand invoke(String in) {
		if(commandMap.containsKey(in))
			return commandMap.get(in);
		else
			return null;
	}

}
