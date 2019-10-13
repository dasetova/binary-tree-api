package com.dasetova.binarytreeapi.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.dasetova.binarytreeapi.models.BinaryTree;

public class BinaryTreeRepositoryTest {
	
	private BinaryTreeRepository treeRepository;

	@Before
	public void setUp() {
		treeRepository = new BinaryTreeRepository();
	}
	
	@Test
	public void whenAddingMoreTreesIncreaseIds() {
		BinaryTree firstTree = treeRepository.generate(10, 10);
		assertNotNull(firstTree);
		assertEquals(firstTree.getSize(), Integer.valueOf(10));
		assertEquals(firstTree.getId(), Integer.valueOf(1));
		
		BinaryTree secondTree = treeRepository.generate(10, 10);
		assertNotNull(secondTree);
		assertEquals(secondTree.getSize(), Integer.valueOf(10));
		assertEquals(secondTree.getId(), Integer.valueOf(2));
	}
}
