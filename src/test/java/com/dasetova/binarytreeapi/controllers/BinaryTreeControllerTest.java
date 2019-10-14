package com.dasetova.binarytreeapi.controllers;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

import com.dasetova.binarytreeapi.exceptions.NotFoundException;
import com.dasetova.binarytreeapi.models.Node;
import com.dasetova.binarytreeapi.repositories.BinaryTreeRepository;
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
	
	@MockBean
	private BinaryTreeRepository treeRepository;
	
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
	
	@Test
	public void whenSendingTreeIdToGetLCA_thenBadRequestResponse() throws Exception {
		when(treeService.getLowestCommonAncestor(Mockito.eq(-1), Mockito.anyInt(), Mockito.anyInt())).thenThrow(NotFoundException.class);
		performGetLowestCommonAncestorRequest(-1, 10, 100, MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void whenSendingValidParamsToGetLCA_thenOkResponse() throws Exception {
		when(treeService.getLowestCommonAncestor(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(new Node(10));
		performGetLowestCommonAncestorRequest(1, 10, 100, MockMvcResultMatchers.status().isOk());
	}
	
	private void performGetLowestCommonAncestorRequest(Integer treeId, Integer value1, Integer value2, ResultMatcher resultStatus) throws Exception {
		String url = String.format("/binary_trees/%s/lowestCommonAncestor?value1=%s&value2=%s", treeId, value1, value2);
		mockMvc.perform(MockMvcRequestBuilders.get(url)
	      .contentType(MediaType.APPLICATION_JSON_UTF8))
	      .andExpect(resultStatus);
	}

}
