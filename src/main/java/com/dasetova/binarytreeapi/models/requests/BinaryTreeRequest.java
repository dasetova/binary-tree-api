package com.dasetova.binarytreeapi.models.requests;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * The Class BinaryTreeRequest.
 * 
 * @author <a href="dasetova@gmail.com">Daniel Torres</a>
 * @version 1.0.0
 * @date 13/10/2019
 */
public class BinaryTreeRequest {

	/** The Constant MIN_TREE_SIZE. */
	private static final long MIN_TREE_SIZE = 1L;

	/** The Constant MAX_TREE_SIZE. */
	private static final long MAX_TREE_SIZE = 100L;

	/** The Constant MIN_VALUE. */
	private static final long MIN_VALUE = 1L;

	/** The Constant MAX_VALUE. */
	private static final long MAX_VALUE = 100L;

	/** The Constant MIN_TREE_SIZE_ERROR. */
	private static final String MIN_TREE_SIZE_ERROR = "The Tree Size should not be less than " + MIN_TREE_SIZE;

	/** The Constant MAX_TREE_SIZE_ERROR. */
	private static final String MAX_TREE_SIZE_ERROR = "The Tree Size should not be greater than " + MAX_TREE_SIZE;

	/** The Constant MIN_VALUE_ERROR. */
	private static final String MIN_VALUE_ERROR = "The Tree Size should not be less than " + MIN_VALUE;

	/** The Constant MAX_VALUE_ERROR. */
	private static final String MAX_VALUE_ERROR = "The Tree Size should not be greater than " + MAX_VALUE;

	/** The tree size. */
	@Min(value = MIN_TREE_SIZE, message = MIN_TREE_SIZE_ERROR)
	@Max(value = MAX_TREE_SIZE, message = MAX_TREE_SIZE_ERROR)
	private Integer treeSize;

	/** The max value. */
	@Min(value = MIN_VALUE, message = MIN_VALUE_ERROR)
	@Max(value = MAX_VALUE, message = MAX_VALUE_ERROR)
	private Integer maxValue;

	/** The valid values. */
	@AssertTrue(message = "The treeSize must be greater or equal than the maxValue")
	private boolean validValues;

	/**
	 * Instantiates a new binary tree request.
	 *
	 * @param treeSize the tree size
	 * @param maxValue the max value
	 */
	public BinaryTreeRequest(Integer treeSize, Integer maxValue) {
		this.treeSize = treeSize;
		this.maxValue = maxValue;
		this.validValues = this.treeSize <= this.maxValue;
	}

	/**
	 * Gets the tree size.
	 *
	 * @return the tree size
	 */
	public Integer getTreeSize() {
		return treeSize;
	}

	/**
	 * Sets the tree size.
	 *
	 * @param treeSize the new tree size
	 */
	public void setTreeSize(Integer treeSize) {
		this.treeSize = treeSize;
	}

	/**
	 * Gets the max value.
	 *
	 * @return the max value
	 */
	public Integer getMaxValue() {
		return maxValue;
	}

	/**
	 * Sets the max value.
	 *
	 * @param maxValue the new max value
	 */
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * Checks if is valid values.
	 *
	 * @return true, if is valid values
	 */
	public boolean isValidValues() {
		return this.validValues;
	}

	/**
	 * Sets the valid values.
	 *
	 * @param validValues the new valid values
	 */
	public void setValidValues(boolean validValues) {
		this.validValues = validValues;
	}

}
