package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.conradoqg.studydsa.hackerrank.challenges.ctci.IsBinarySearchTree.Node;

public class IsBinarySearchTreeTest {

	@Test
	public void testCheckBSTCase1() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node4.left = node2;
		node4.right = node6;
		node2.left = node1;
		node2.right = node3;
		node6.left = node5;
		node6.right = node7;
		
		assertTrue(IsBinarySearchTree.checkBST(node4));
	}

	@Test
	public void testCheckBSTCase2() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node2.left = node1;
		node2.right = node3;
		node3.right = node5;
		node5.left = node4;
		node5.right = node6;
		node6.right = node7;
		
		assertTrue(IsBinarySearchTree.checkBST(node2));
	}
	
	@Test
	public void testCheckBSTCase3() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(2);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node2.left = node1;
		node2.right = node3;
		node3.right = node4;
		node4.right = node5;
		node5.right = node6;
		node6.right = node7;
		
		assertFalse(IsBinarySearchTree.checkBST(node2));
	}
}
