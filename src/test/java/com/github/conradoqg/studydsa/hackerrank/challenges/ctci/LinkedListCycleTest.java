package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListCycleTest {

	@Test
	public void testHasCycle_Case1() {
		LinkedListCycle.Node node0 = new LinkedListCycle.Node(0);
		LinkedListCycle.Node node1 = new LinkedListCycle.Node(1);
		LinkedListCycle.Node node2 = new LinkedListCycle.Node(2);
		
		node0.next = node1;
		node1.next = node2;
		
		assertFalse(LinkedListCycle.hasCycle(node0));
	}

	@Test
	public void testHasCycle_Case2() {
		LinkedListCycle.Node node0 = new LinkedListCycle.Node(0);
		LinkedListCycle.Node node1 = new LinkedListCycle.Node(1);
		LinkedListCycle.Node node2 = new LinkedListCycle.Node(2);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node0;
		
		assertTrue(LinkedListCycle.hasCycle(node0));
	}
}
