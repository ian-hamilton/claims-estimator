/**
 * 
 */
package com.inertia.solutions.claims.mvc.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;
import com.inertia.solutions.claims.mvc.domain.service.ClaimItemService;


/**
 * Using JRE 1.7.0_75
 * 
 * The Class ClaimItemsRestController which is a basic controller for
 * the main RESTful HTTP types. Except "PUT" since angular really uses
 * either POST or PUT for update transactions.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping("/service/claimitems")
public class ClaimItemsRestController {
	private static final String ACCEPT_APPLICATION_JSON = "Accept=application/json";

	
	@Autowired
	ClaimItemService claimItemService;
	
    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public Collection<ClaimItem> getAll(@RequestParam String claimType) {
    	return claimItemService.findAllClaimItems(claimType);
    }
    

    @RequestMapping(method = RequestMethod.POST, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public ClaimItem put(@RequestBody ClaimItem claimItem) {
    	return claimItemService.saveClaimItem(claimItem);
    }
    

    @RequestMapping(method = RequestMethod.DELETE, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public void delete(@RequestParam(required = false) String id) {
    	if(!StringUtils.isEmpty(id)) 
    		claimItemService.deleteClaimItem(id);
    }   	
	

    @ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception ex) {
		return ex.getMessage();
	}

}
