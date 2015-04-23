/**
 * 
 */
package com.inertia.solutions.claims.mvc.rest.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
 * @author ihamilto
 *
 */
@Controller
@RequestMapping("/service/claimitems")
public class ClaimItemsRestController {
	
	private static final String ACCEPT_APPLICATION_JSON = "Accept=application/json";
	private static final Logger log = LoggerFactory.getLogger(ClaimItemsRestController.class);
	
	@Autowired
	ClaimItemService claimItemService;
	
    @RequestMapping(method = RequestMethod.GET, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public Collection<ClaimItem> getAll() {
    	return claimItemService.findAllClaimItems();
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
	public void delete(@RequestParam String id) {
    	log.debug("Parm ->" + id);
    	claimItemService.deleteClaimItem(id);
    }
	
    @ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception ex) {
		log.error("Exception during controller handling", ex);
		return null;
	}

}
