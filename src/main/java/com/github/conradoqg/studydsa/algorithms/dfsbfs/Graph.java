package com.github.conradoqg.studydsa.algorithms.dfsbfs;

import java.util.HashMap;

public class Graph {
	HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	
	public Node addNode(int id) {
		return nodeLookup.put(id, new Node(id));
	}
	
	public Node getNode(Integer node) {
		return nodeLookup.get(node);
	}
	
	public void addEdge(Integer source, Integer destination) {
		Node sourceNode = nodeLookup.get(source);
		Node destinationNode = nodeLookup.get(destination);
		sourceNode.add(destinationNode);
		destinationNode.add(sourceNode);
	}
}
