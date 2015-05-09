/**
 * 
 */
package com.inertia.solutions.claims.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author devl
 *
 */
@Controller
@RequestMapping(value={"/registration"})
public class RegistrationController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "registration/registration";
	}
}
