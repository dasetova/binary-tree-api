package com.dasetova.binarytreeapi.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void whenAddingNewValueIncreaseSize() {
		BinaryTree tree = new BinaryTree(1);
		assertEquals(tree.getId(), Integer.valueOf(1));
		tree.add(10);
		assertEquals(tree.getSize(), Integer.valueOf(1));
		tree.add(20);
		assertEquals(tree.getSize(), Integer.valueOf(2));
	}

	@Test
	public void whenAddingExistingValueNotIncreaseSize() {
		BinaryTree tree = new BinaryTree(1);
		tree.add(10);
		assertEquals(tree.getRoot().get().getValue(), Integer.valueOf(10));
		assertEquals(tree.getSize(), Integer.valueOf(1));
		tree.add(10);
		assertEquals(tree.getRoot().get().getValue(), Integer.valueOf(10));
		assertEquals(tree.getSize(), Integer.valueOf(1));
	}

	@Test
	public void whenAddingNewValueInsertChildCorrectly() {
		BinaryTree tree = new BinaryTree(1);
		tree.add(10);
		assertEquals(tree.getRoot().get().getValue(), Integer.valueOf(10));
		tree.add(20);
		assertEquals(tree.getRoot().get().getRightChild().get().getValue(), Integer.valueOf(20));
		tree.add(5);
		assertEquals(tree.getRoot().get().getLeftChild().get().getValue(), Integer.valueOf(5));
	}
	
	@Test
	public void whenTreeConstainsValueReturnsTrueOtherwiseReturnsFalse() {
		BinaryTree tree = new BinaryTree(1);
		assertFalse(tree.contains(10));
		tree.add(10);
		assertTrue(tree.contains(10));
		assertFalse(tree.contains(20));
	}
	
	@Test
	public void whenValueIsInRootThenLowestAncestorIsRoot() {
		BinaryTree tree = new BinaryTree(1);
		tree.add(10);
		tree.add(5);
		tree.add(20);
		assertEquals(tree.getRoot(), tree.getLowestCommonAncestor(10, 5));
	}
	
	@Test
	public void whenValueIsntInTreeThenLowestAncestorIsEmpty() {
		BinaryTree tree = new BinaryTree(1);
		assertFalse(tree.getLowestCommonAncestor(10, 5).isPresent());
	}
	
	@Test
	public void whenValuesAreInTreeFindLowestAncestor() {
		BinaryTree tree = new BinaryTree(1);
		tree.add(10);
		tree.add(5);
		tree.add(20);
		tree.add(8);
		tree.add(3);
		assertTrue(tree.getLowestCommonAncestor(3, 8).get().getValue() == 5);
	}

}
