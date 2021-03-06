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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
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
	private static final Logger log = LoggerFactory.getLogger(ClaimItemsRestController.class);
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
	
    @RequestMapping(method = RequestMethod.HEAD)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public String head() throws JsonProcessingException  {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);
        JsonSchema jsonSchema = generator.generateSchema(ClaimItem.class);
        String ret =  mapper.writeValueAsString(jsonSchema);
        log.info(ret);
        return ret;
    }  
    
    
    @RequestMapping(value="/testHead", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public String headTest() throws JsonProcessingException  {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);
        JsonSchema jsonSchema = generator.generateSchema(ClaimItem.class);
        String ret =  mapper.writeValueAsString(jsonSchema);
        return HEAD;
    }  
    
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception ex) {
    	System.out.println("-----------------" + ex.getMessage());
		return ex.getMessage();
	}
    
    final String HEAD = "{\n"+
    		" \"type\":\"object\",\n"+
    		" \"id\":\"urn:jsonschema:com:inertia:solutions:claims:mvc:domain:entity:ClaimItem\",\n"+
    		" \"properties\":{\n"+
    		" \"Id\":{\n"+
    		" \"type\":\"id\"\n"+
    		" },\n"+
    		" \"Claim_Item_Name\":{\n"+
    		" \"type\":\"string\",\n"+
    		" \"required\":true\n"+
    		" }, \n"+
    		" \"Item_Description\":{\n"+
    		" \"type\":\"string\",\n"+
    		" \"required\":true\n"+
    		" },\n"+
    		" \"Notes\":{\n"+
    		" \"type\":\"textarea\"\n"+
    		" },\n"+
    		" \"Category\":{\n"+
    		" \"type\":\"string\",\n"+
    		" \"required\":true\n"+
    		" },\n"+
    		" \"Sel\":{\n"+
    		" \"type\":\"string\"\n"+
    		" },\n"+
    		" \"Default_Calculation\":{\n"+
    		" \"type\":\"string\",\n"+
    		" \"required\":true\n"+
    		" },\n"+
    		" \"Replace_Amount\":{\n"+
    		" \"type\":\"number\",\n"+
    		" \"required\":true\n"+
    		" },\n"+
    		" \"Removal_Amount\":{\n"+
    		" \"type\":\"number\",\n"+
    		" \"required\":true\n"+
    		" },\n"+
    		" \"Total_Amount\":{\n"+
    		" \"type\":\"number\",\n"+
    		" \"required\":true\n"+
    		" },\n"+
    		" \"Item_Type\":{\n"+
    		" \"type\":\"string\",\n"+
    		" \"required\":true\n"+
    		" }\n"+
    		" }\n"+
    		"}";

}
