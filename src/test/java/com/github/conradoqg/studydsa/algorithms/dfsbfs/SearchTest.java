package com.github.conradoqg.studydsa.algorithms.dfsbfs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.conradoqg.studydsa.algorithms.dfsbfs.Graph;
import com.github.conradoqg.studydsa.algorithms.dfsbfs.Search;

public class SearchTest {
	
	private Graph createTestGraph() {
		/*
		 * Graph:
		 *            1
		 *          /   \
		 *         2 --- 3
		 *   
		 *         4 --- 5
		 */
		Graph graph = new Graph();
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(4, 5);
		return graph;
	}

	@Test
	public void hasDFSPath_Case1() {
		Graph graph = createTestGraph();		
		
		assertTrue(Search.hasDFSPath(graph, 1, 2));
		assertTrue(Search.hasDFSPath(graph, 1, 3));
		assertTrue(Search.hasDFSPath(graph, 3, 2));
		assertFalse(Search.hasDFSPath(graph, 1, 5));
	}
	
	@Test
	public void hasBFSPath_Case1() {
		Graph graph = createTestGraph();
		
		assertTrue(Search.hasBFSPath(graph, 1, 2));
		assertTrue(Search.hasBFSPath(graph, 1, 3));
		assertTrue(Search.hasBFSPath(graph, 3, 2));
		assertFalse(Search.hasBFSPath(graph, 1, 5));
	}
}
