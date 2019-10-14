package com.dasetova.binarytreeapi.models;

import java.util.Optional;

/**
 * The Class BinaryTree.
 *
 * @author <a href="dasetova@gmail.com">Daniel Torres</a>
 * @version 1.0.0
 * @date 13/10/2019
 */
public class BinaryTree {

	/** The id. */
	private Integer id;

	/** The root. */
	private Optional<Node> root;

	private Integer size;

	/**
	 * Instantiates a new binary tree.
	 */
	public BinaryTree(Integer id) {
		this.id = id;
		this.root = Optional.empty();
		this.size = 0;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	public Optional<Node> getRoot() {
		return root;
	}

	public Integer getSize() {
		return size;
	}

	/**
	 * Adds the.
	 *
	 * @param value the value
	 */
	public void add(int value) {
		root = add(root, value);
	}

	/**
	 * Adds the.
	 *
	 * @param current the current
	 * @param value   the value
	 * @return the optional
	 */
	private Optional<Node> add(Optional<Node> current, int value) {
		if (!current.isPresent()) {
			this.size++;
			return Optional.of(new Node(value));
		}

		Node currentNode = current.get();
		if (currentNode.getValue() == value) {
			return current;
		}

		if (value < currentNode.getValue()) {
			currentNode.setLeftChild(add(currentNode.getLeftChild(), value));
		} else {
			currentNode.setRightChild(add(currentNode.getRightChild(), value));
		}

		return Optional.of(currentNode);
	}

	/**
	 * Check if a value is in the tree
	 *
	 * @param value the value
	 * @return true, if exists
	 */
	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Optional<Node> current, int value) {
		if (!current.isPresent()) {
			return false;
		}

		Node currentNode = current.get();
		if (currentNode.getValue() == value) {
			return true;
		}
		return currentNode.getValue() > value ? contains(currentNode.getLeftChild(), value)
				: contains(currentNode.getRightChild(), value);
	}
	
	/**
	 * Gets the lowest common ancestor.
	 *
	 * @param value1 the value 1
	 * @param value2 the value 2
	 * @return the lowest common ancestor
	 */
	public Optional<Node> getLowestCommonAncestor(Integer value1, Integer value2) {
		return getLowestCommonAncestor(root, value1, value2);
	}

	private Optional<Node> getLowestCommonAncestor(Optional<Node> current, Integer value1, Integer value2) {

		if (!current.isPresent()) {
			return current;
		}

		Node currentNode = current.get();

		if (currentNode.getValue() == value1 || currentNode.getValue() == value2) {
			return current;
		}

		Optional<Node> leftLCA = getLowestCommonAncestor(currentNode.getLeftChild(), value1, value2);
		Optional<Node> rightLCA = getLowestCommonAncestor(currentNode.getRightChild(), value1, value2);

		if (leftLCA.isPresent() && rightLCA.isPresent()) {
			return current;
		}

		return (leftLCA.isPresent()) ? leftLCA : rightLCA;

	}
}
