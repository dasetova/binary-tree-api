package com.dasetova.binarytreeapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasetova.binarytreeapi.models.BinaryTree;
import com.dasetova.binarytreeapi.repositories.IBinaryTreeRepository;


/**
 * The Class BinaryTreeService.
 * 
 * @author <a href="dasetova@gmail.com">Daniel Torres</a>
 * @version 1.0.0
 * @date 13/10/2019
 */
@Service
public class BinaryTreeService implements IBinaryTreeService {

	/** The tree repository. */
	private IBinaryTreeRepository treeRepository;
	
	/**
	 * Instantiates a new binary tree service.
	 *
	 * @param treeRepository the tree repository
	 */
	public BinaryTreeService(@Autowired IBinaryTreeRepository treeRepository) {
		this.treeRepository = treeRepository;
	}

	/**
	 * Creates the binary tree.
	 *
	 * @param maxValue the max value
	 * @param treeSize the tree size
	 * @return the binary tree
	 */
	@Override
	public BinaryTree createBinaryTree(Integer maxValue, Integer treeSize) {
		return treeRepository.generate(maxValue, treeSize);
	}

}
