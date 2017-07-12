package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueUsingTwoStacksTest {

	@Test
	public void test_Case1() {
		QueueUsingTwoStacks.MyQueue<Integer> queue = new QueueUsingTwoStacks.MyQueue<Integer>();
		queue.enqueue(42);
		queue.dequeue();
		queue.enqueue(14);
		assertTrue(queue.peek() == 14);
		queue.enqueue(28);
		assertTrue(queue.peek() == 14);
		queue.enqueue(60);
		queue.enqueue(78);
		queue.dequeue();
		queue.dequeue();
		assertTrue(queue.peek() == 60);
	}

}
