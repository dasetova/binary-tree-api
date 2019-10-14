package com.dasetova.binarytreeapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasetova.binarytreeapi.exceptions.NotFoundException;
import com.dasetova.binarytreeapi.models.BinaryTree;
import com.dasetova.binarytreeapi.models.Node;
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

	private static final String TREE_NOT_FOUND = "The tree with id %s doesn't exists";

	private static final String NODE_NOT_FOUND = "The node with value %s doesn't exists for tree %s";

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

	/**
	 * Gets the lowest common ancestor.
	 *
	 * @param treeId the tree id
	 * @param value1 the value 1
	 * @param value2 the value 2
	 * @return the lowest common ancestor
	 */
	@Override
	public Node getLowestCommonAncestor(Integer treeId, Integer value1, Integer value2) {

		BinaryTree tree = this.treeRepository.getById(treeId)
				.orElseThrow(() -> new NotFoundException(String.format(TREE_NOT_FOUND, treeId)));
		validateRequestParams(tree, value1, value2);

		return tree.getLowestCommonAncestor(value1, value2).get();
	}

	/**
	 * Validate request params.
	 *
	 * @param tree the tree
	 * @param value1 the value 1
	 * @param value2 the value 2
	 */
	private void validateRequestParams(BinaryTree tree, Integer value1, Integer value2) {
		if (!tree.contains(value1)) {
			throw new NotFoundException(String.format(NODE_NOT_FOUND, tree.getId(), value1));
		}
		if (!tree.contains(value2)) {
			throw new NotFoundException(String.format(NODE_NOT_FOUND, tree.getId(), value2));
		}
	}

}
