package com.github.conradoqg.studydsa.algorithms.dfsbfs;

import java.util.LinkedList;

public class Node {
	private int id;
	private LinkedList<Node> adjacents = new LinkedList<Node>();
	
	public Node() {	
	}
	
	public Node(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean add(Node node) {
		return adjacents.add(node);
	}
	
	public LinkedList<Node> getAdjacents() {
		return adjacents;
	}
}
