package com.dasetova.binarytreeapi.repositories;

import com.dasetova.binarytreeapi.models.BinaryTree;

public interface IBinaryTreeRepository {
	
	public BinaryTree generate(Integer maxValue, Integer treeSize);

}
