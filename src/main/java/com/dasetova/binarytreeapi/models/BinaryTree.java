package com.dasetova.binarytreeapi.models;

import java.util.Optional;

/**
 * The Class BinaryTree.
 * 
 * @author Daniel Torres dasetova@gmail.com
 * 
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
	 * @param value the value
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

}
