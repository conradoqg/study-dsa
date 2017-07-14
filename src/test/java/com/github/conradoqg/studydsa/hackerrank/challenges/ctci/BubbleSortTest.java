package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void testSort_Case1() {
		int[] a = { 1, 2, 3 };
		int[] target = { 1, 2, 3 };
		int n = 3;
		BubbleSort.totalSwaps = 0;
		assertTrue(Arrays.equals(BubbleSort.sort(a, n),target));
		assertTrue(BubbleSort.totalSwaps == 0);
	}

	@Test
	public void testSort_Case2() {
		int[] a = { 3, 2, 1 };
		int[] target = { 1, 2, 3 };
		int n = 3;
		BubbleSort.totalSwaps = 0;
		assertTrue(Arrays.equals(BubbleSort.sort(a, n),target));
		assertTrue(BubbleSort.totalSwaps == 3);
	}
}
