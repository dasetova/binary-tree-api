package com.dasetova.binarytreeapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RestController("/binary_trees")
public class BinaryTreeController {

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
}
