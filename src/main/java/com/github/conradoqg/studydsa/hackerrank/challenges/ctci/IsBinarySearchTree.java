package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.Collections;
import java.util.function.Function;

public class IsBinarySearchTree {
	
	public static void main(String[] args) {
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

		System.out.println(node4.toString());
		System.out.println(checkBST(node4));
	}

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return this.toString(1);
		}

		public String toString(int level) {
			String right = (this.right != null ? this.right.toString(level + 1) : "");
			String left = (this.left != null ? this.left.toString(level + 1) : "");
			return (level == 1 ? "" : "\t") + this.data
					+ (!right.isEmpty() ? " -> " + right : "")
					+ (!left.isEmpty() ? "\n" + String.join("", Collections.nCopies(level - 1, "\t")) + left : "");
		}
	}
	
	private static Integer lastTraversed;

	public static boolean checkBST(Node root) {
		if (root == null) return false;
		lastTraversed = null;
		return traverseInOrder(root, IsBinarySearchTree::checkNode);
	}
	
	private static boolean traverseInOrder(Node node, Function<Node, Boolean> checker) {
		boolean result = true;
		if (node.left != null) result = traverseInOrder(node.left, checker);
		if (result && !checker.apply(node)) result = false;
		if (result && node.right != null) result = traverseInOrder(node.right, checker);
		return result;
	}
	
	private static boolean checkNode(Node node) {
		if (lastTraversed == null || node.data > lastTraversed) {
			lastTraversed = node.data;
			return true;
		} else {
			return false;
		}
	}
}
