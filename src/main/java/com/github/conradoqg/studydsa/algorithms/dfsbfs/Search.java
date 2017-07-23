package com.github.conradoqg.studydsa.algorithms.dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;

public class Search {
	public static boolean hasDFSPath(Graph graph, int source, int destination) {
		HashSet<Integer> visitedNodes = new HashSet<Integer>();
		Node sourceNode = graph.getNode(source);
		Node destinationNode = graph.getNode(destination);
		return hasDFSPath(sourceNode, destinationNode, visitedNodes);
	}

	private static boolean hasDFSPath(Node sourceNode, Node destinationNode, HashSet<Integer> visitedNodes) {
		if (visitedNodes.contains(sourceNode.getId()))
			return false;
		if (sourceNode == destinationNode)
			return true;
		visitedNodes.add(sourceNode.getId());

		for (Node child : sourceNode.getAdjacents()) {
			if (hasDFSPath(child, destinationNode, visitedNodes)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasBFSPath(Graph graph, int source, int destination) {
		Node sourceNode = graph.getNode(source);
		Node destinationNode = graph.getNode(destination);

		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		HashSet<Integer> visited = new HashSet<Integer>();
		nextToVisit.add(sourceNode);

		while (!nextToVisit.isEmpty()) {
			Node nextNode = nextToVisit.remove();
			if (nextNode == destinationNode)
				return true;
			if (visited.contains(nextNode.getId()))
				continue;
			visited.add(nextNode.getId());

			for (Node child : nextNode.getAdjacents()) {
				nextToVisit.add(child);
			}
		}

		return false;
	}
}
