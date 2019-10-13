package com.dasetova.binarytreeapi.repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.dasetova.binarytreeapi.models.BinaryTree;

/**
 * The type Binary Tree Repository
 *
 * @author <a href="dasetova@gmail.com">Daniel Torres</a>
 * @version 1.0.0
 * @date 13/10/2019
 */
@Component
public class BinaryTreeRepository implements IBinaryTreeRepository {
	
	/** The binary trees. */
	private static Set<BinaryTree> binaryTrees = new HashSet<>();

	/** The current id. */
	private static Integer currentId = 0;

	/**
	 * Generates a BinaryTree according to the given parameters
	 *
	 * @param maxValue the max value
	 * @param treeSize the tree size
	 * @return the binary tree
	 */
	public BinaryTree generate(Integer maxValue, Integer treeSize) {
		List<Integer> values = this.generateTreeValues(maxValue, treeSize);
		BinaryTree tree = new BinaryTree(this.nextId());
		values.forEach((value) -> tree.add(value));
		binaryTrees.add(tree);
		return tree;
	}

	/**
	 * Returns the Next id to create a Tree
	 *
	 * @return the integer
	 */
	private Integer nextId() {
		currentId++;
		return currentId;
	}

	/**
	 * Generate tree values according to given maxValue and treeSize
	 *
	 * @param maxValue the max value
	 * @param treeSize the tree size
	 * @return the list
	 */
	private List<Integer> generateTreeValues(Integer maxValue, Integer treeSize) {
		List<Integer> values = new ArrayList<Integer>();
		Random random = new Random();

		while (values.size() < treeSize) {
			Integer randomInteger = random.nextInt(maxValue);
			if (!values.contains(randomInteger)) {
				values.add(randomInteger);
			}
		}

		return values;
	}
}
