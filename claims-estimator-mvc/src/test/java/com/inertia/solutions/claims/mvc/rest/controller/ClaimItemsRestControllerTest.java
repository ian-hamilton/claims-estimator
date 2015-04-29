package com.inertia.solutions.claims.mvc.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.GsonBuilder;
import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;
import com.inertia.solutions.claims.mvc.domain.service.ClaimItemService;
import com.inertia.solutions.claims.mvc.test.util.MockApplicationContext;
import com.inertia.solutions.claims.mvc.web.config.WebContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebContext.class,
		MockApplicationContext.class })
@WebAppConfiguration
@DirtiesContext
public class ClaimItemsRestControllerTest {

	@Autowired
	WebApplicationContext dirtiedWebContext;

	@Autowired
	ClaimItemService cs;

	MockMvc mockMvc;

	List<ClaimItem> listExpectation = new ArrayList<ClaimItem>();
	
	ClaimItem itemExpectation = new ClaimItem();

	@Before
	public void setup() {		
		mockMvc = MockMvcBuilders.webAppContextSetup(this.dirtiedWebContext).build();
		
		listExpectation.add(itemExpectation);
		Mockito.when(cs.findAllClaimItems(Mockito.anyString())).thenReturn(listExpectation);	
		Mockito.when(cs.saveClaimItem(Mockito.any(ClaimItem.class))).thenReturn(itemExpectation);
		Mockito.doThrow(new IllegalStateException("Test Exception")).when(cs).deleteClaimItem("throw-on-this-id");
	}

	@Test
	public void testGetAll() throws Exception {
		final String type = "property";
		mockMvc.perform(
				get("/service/claimitems").param("claimType", type).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		Mockito.verify(cs).findAllClaimItems(type);
	}

	@Test
	public void testDelete() throws Exception {
		String id = "123";
		mockMvc.perform(
				delete("/service/claimitems").param("id",  id).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Mockito.verify(cs).deleteClaimItem(id);
	}

	@Test
	public void testPut() throws Exception {
		String json = new GsonBuilder().create().toJson(new ClaimItem());
		mockMvc.perform(
				post("/service/claimitems").content(json).contentType(MockApplicationContext.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		Mockito.verify(cs).saveClaimItem(Mockito.any(ClaimItem.class));
	}

	@Test()
	public void testHandleException() throws Exception {
		String id = "throw-on-this-id";
		mockMvc.perform(
				delete("/service/claimitems").param("id",  id).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}



}
