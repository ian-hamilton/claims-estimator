/**
 * 
 */
package com.inertia.solutions.claims.mvc.rest.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;
import com.inertia.solutions.claims.mvc.domain.service.ClaimItemService;

/**
 * @author ihamilto
 *
 */
@Controller
@RequestMapping("/claims")
public class ClaimItemsRestController {
	private static final Logger log = Logger.getLogger(ClaimItemsRestController.class);
	
	@Autowired
	ClaimItemService claimItemService;
	
	
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public Collection<ClaimItem> getAll() {
    	return claimItemService.findAll();
    }
	
    @ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception ex) {
		log.error("Exception during controller handling", ex);
		return null;
	}

}