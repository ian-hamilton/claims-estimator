package com.inertia.solutions.claims.mvc.rest.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.inertia.solutions.claims.mvc.domain.entity.UserRegistration;
import com.inertia.solutions.claims.mvc.domain.repository.UserRegistrationRepositoryImpl;

@Controller
@RequestMapping("/service/userregistration")
public class UserRegistrationRestController {
	private static final String ACCEPT_APPLICATION_JSON = "Accept=application/json";
	
	@Autowired
	UserRegistrationRepositoryImpl repository;

    @RequestMapping(method = RequestMethod.POST, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public UserRegistration post(@RequestBody UserRegistration userRegistration) throws Exception {
    	List<UserRegistration>  result = repository.getUserRegistrationByEmail(userRegistration.getEmailAddress());
    	if(result.size() > 0){
    		throw new Exception("email address already exists");
    	}
    	
    	return repository.insert(userRegistration);
    }
    
    @RequestMapping(method = RequestMethod.GET, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<UserRegistration> get(@RequestParam String email){
    	if(email == null) 
    		return repository.findAll();
    	 else
    		return repository.getUserRegistrationByEmail(email);
    }
	
}
