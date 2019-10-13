package com.dasetova.binarytreeapi.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dasetova.binarytreeapi.services.BinaryTreeService;

/**
 * The Class BinaryTreeControllerTest.
 * 
 * @author <a href="dasetova@gmail.com">Daniel Torres</a>
 * @version 1.0.0
 * @date 13/10/2019
 */
@RunWith(SpringRunner.class) 
@WebMvcTest
@AutoConfigureMockMvc
public class BinaryTreeControllerTest {
	
	@MockBean
	private BinaryTreeService treeService;
	
	@Autowired
	BinaryTreeController treeController;
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void whenSendingWrongMaxValueToCreate_thenBadRequestResponse() throws Exception {
		performCreateRequest(-1, 100, MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void whenSendingWrongTreeSizeToCreate_thenBadRequestResponse() throws Exception {
		performCreateRequest(100, -1, MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void whenSendingWrongTreeSizeGreaterThanMaxValueToCreate_thenBadRequestResponse() throws Exception {
		performCreateRequest(10, 100, MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void whenSendingValidRequestToCreate_thenOkResponse() throws Exception {
		performCreateRequest(100, 100, MockMvcResultMatchers.status().isCreated());
	}
	
	private void performCreateRequest(Integer maxValue, Integer treeSize, ResultMatcher resultStatus) throws Exception {
		String request = String.format("{\"treeSize\": %s, \"maxValue\" : %s}", treeSize, maxValue);
	    mockMvc.perform(MockMvcRequestBuilders.post("/binary_trees")
	      .content(request)
	      .contentType(MediaType.APPLICATION_JSON_UTF8))
	      .andExpect(resultStatus);
	}

}
