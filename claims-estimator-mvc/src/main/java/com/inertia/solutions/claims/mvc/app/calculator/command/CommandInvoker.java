package com.inertia.solutions.claims.mvc.app.calculator.command;

public interface CommandInvoker<T, R> {

	public R invoke(T in);
	
}
