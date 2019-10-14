package com.dasetova.binarytreeapi.services;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.dasetova.binarytreeapi.exceptions.NotFoundException;
import com.dasetova.binarytreeapi.models.BinaryTree;
import com.dasetova.binarytreeapi.repositories.IBinaryTreeRepository;

public class BinaryTreeServiceTest {
	
	@Mock
    private IBinaryTreeRepository treeRepository;
	
	private BinaryTreeService treeService;
	
	@Before
	public void setUp() {
		initMocks(this);
		treeService = new BinaryTreeService(treeRepository);
	}
	
	@Test
	public void whenCallCreateBinaryTreeReturnsNewTree() {
		when(treeRepository.generate(10, 10)).thenReturn(new BinaryTree(1));
		BinaryTree tree = this.treeService.createBinaryTree(10, 10);
		assertNotNull(tree);
	}
	
	@Test(expected = NotFoundException.class)
	public void whenCallGetLowestWithInvalidTreeIdThrowsException() {
		Optional<BinaryTree> noTree = Optional.ofNullable(null);
		when(treeRepository.getById(Mockito.anyInt())).thenReturn(noTree);
		treeService.getLowestCommonAncestor(0, 10, 5);
	}
	
	@Test(expected = NotFoundException.class)
	public void whenCallGetLowestWithValidTreeButInvalidFirstValueThrowsException() {
		Optional<BinaryTree> tree = Optional.of(new BinaryTree(1));
		when(treeRepository.getById(Mockito.anyInt())).thenReturn(tree);
		treeService.getLowestCommonAncestor(0, 10, 5);
	}
	
	@Test(expected = NotFoundException.class)
	public void whenCallGetLowestWithValidTreeButInvalidSecondValueThrowsException() {
		BinaryTree tree = new BinaryTree(1);
		tree.add(10);
		Optional<BinaryTree> validTree = Optional.of(tree);
		when(treeRepository.getById(Mockito.anyInt())).thenReturn(validTree);
		treeService.getLowestCommonAncestor(tree.getId(), 10, 5);
	}
	
	@Test
	public void whenCallGetLowestWithValidParamsReturnsLCA() {
		BinaryTree tree = new BinaryTree(1);
		tree.add(10);tree.add(5);tree.add(20);
		Optional<BinaryTree> validTree = Optional.of(tree);
		when(treeRepository.getById(Mockito.anyInt())).thenReturn(validTree);
		assertTrue(treeService.getLowestCommonAncestor(tree.getId(), 5, 20).getValue() == 10);
	}

}
