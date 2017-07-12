package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.HashSet;

public class LinkedListCycle {

	public static void main(String[] args) {
		
	}
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static boolean hasCycle(Node head) {
		if (head == null) return false;
	
		HashSet<Node> visitedNodes = new HashSet<Node>();
		
		Node currentNode = head; 
		while (currentNode != null) {			
			if (visitedNodes.contains(currentNode)) return true;
			else visitedNodes.add(currentNode);
			currentNode = currentNode.next;
		};
		
		return false;
	}
}
