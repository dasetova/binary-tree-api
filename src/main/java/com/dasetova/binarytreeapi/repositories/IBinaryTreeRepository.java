package com.dasetova.binarytreeapi.repositories;

import com.dasetova.binarytreeapi.models.BinaryTree;

/**
 * The Interface Binary Tree Repository
 *
 * @author <a href="dasetova@gmail.com">Daniel Torres</a>
 * @version 1.0.0
 * @date 13/10/2019
 */
public interface IBinaryTreeRepository {
	
	public BinaryTree generate(Integer maxValue, Integer treeSize);

}
