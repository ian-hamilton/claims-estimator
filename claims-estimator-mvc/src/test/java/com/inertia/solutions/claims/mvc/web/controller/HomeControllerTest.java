package com.inertia.solutions.claims.mvc.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HomeControllerTest {

	HomeController controllerUnderTest;
	
	@Before
	public void setup() {
		controllerUnderTest = new HomeController();
	}
	
	@Test
	public void testGet() throws Exception {
		String result = controllerUnderTest.get(null);
		assertEquals("home", result);
	}

}
