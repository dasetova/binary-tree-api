package com.dasetova.binarytreeapi.models;

import java.util.Optional;

/**
 * The Class Node.
 * 
 * @author Daniel Torres dasetova@gmail.com
 */
public class Node {

	/** The value. */
	private Integer value;

	/** The left child. */
	private Optional<Node> leftChild;

	/** The right child. */
	private Optional<Node> rightChild;

	/**
	 * Instantiates a new node.
	 *
	 * @param value the value
	 */
	public Node(Integer value) {
		this.value = value;
		this.leftChild = Optional.empty();
		this.rightChild = Optional.empty();
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * Gets the left child.
	 *
	 * @return the left child
	 */
	public Optional<Node> getLeftChild() {
		return leftChild;
	}

	/**
	 * Sets the left child.
	 *
	 * @param leftChild the new left child
	 */
	public void setLeftChild(Optional<Node> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Gets the right child.
	 *
	 * @return the right child
	 */
	public Optional<Node> getRightChild() {
		return rightChild;
	}

	/**
	 * Sets the right child.
	 *
	 * @param rightChild the new right child
	 */
	public void setRightChild(Optional<Node> rightChild) {
		this.rightChild = rightChild;
	}

}
