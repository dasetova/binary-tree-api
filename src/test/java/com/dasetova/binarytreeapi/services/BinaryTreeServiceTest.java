package com.dasetova.binarytreeapi.services;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

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

}
