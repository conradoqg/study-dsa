package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConnectedCellInAGridTest {

	@Test
	public void testSolution1() {
		int[][] grid = { { 1, 1, 1, 0 }, { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 0, 0 } };
		assertTrue(ConnectedCellInAGrid.solution1(4, 4, grid) == 8);
	}

}
