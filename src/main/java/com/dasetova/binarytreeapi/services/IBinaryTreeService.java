package com.dasetova.binarytreeapi.services;

import com.dasetova.binarytreeapi.models.BinaryTree;

/**
 * The Interface IBinaryTreeService.
 * 
 * @author <a href="dasetova@gmail.com">Daniel Torres</a>
 * @version 1.0.0
 * @date 13/10/2019
 */
public interface IBinaryTreeService {

	public BinaryTree createBinaryTree(Integer maxValue, Integer treeSize);
}
