package com.inertia.solutions.claims.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * http://localhost:8080/claims-estimator-mvc/home
 * 
 * Basic Web Controller (Html)
 */

@Controller
@RequestMapping(value={"/home","/"})
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "home";
	}
	
}
