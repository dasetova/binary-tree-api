package com.dasetova.binarytreeapi.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dasetova.binarytreeapi.models.BinaryTree;
import com.dasetova.binarytreeapi.models.requests.BinaryTreeRequest;
import com.dasetova.binarytreeapi.services.IBinaryTreeService;

/**
 * The Class BinaryTreeController.
 * 
 * @author <a href="dasetova@gmail.com">Daniel Torres</a>
 * @version 1.0.0
 * @date 13/10/2019
 */
@RequestMapping(value="/binary_trees")
@RestController
public class BinaryTreeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BinaryTreeController.class);
	
	/** The tree service. */
	@Autowired
	private IBinaryTreeService treeService;
	
	/**
	 * Creates the.
	 *
	 * @param binaryTreeRequest the binary tree request
	 * @return the binary tree
	 */
	@PostMapping
	@ResponseStatus(value=HttpStatus.CREATED)
	public @ResponseBody BinaryTree create(@Valid @RequestBody BinaryTreeRequest binaryTreeRequest) {
		return treeService.createBinaryTree(binaryTreeRequest.getMaxValue(), binaryTreeRequest.getTreeSize());
	}
	
	@GetMapping(value = "/{treeId}/lowestCommonAncestor")
	public @ResponseBody Integer getLowestCommonAncestor(@PathVariable Integer treeId,
			@RequestParam("value1") Integer value1, @RequestParam("value2") Integer value2) {
		LOGGER.info("Request for lowestCommonAncestor received, treeId: {}, value1: {}, value2: {}", treeId, value1, value2);
		return treeService.getLowestCommonAncestor(Integer.valueOf(treeId), value1, value2).getValue();
	}
}
