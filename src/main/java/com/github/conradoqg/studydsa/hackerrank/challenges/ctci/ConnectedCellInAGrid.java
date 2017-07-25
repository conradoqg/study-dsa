package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class ConnectedCellInAGrid {

	private static class Node {
		private LinkedList<Node> adjacents = new LinkedList<Node>();

		public boolean connectTo(Node adjacent) {
			if (adjacent.add(this))
				return this.add(adjacent);

			return false;
		}

		public boolean add(Node adjacent) {
			if (!this.adjacents.contains(adjacent))
				return this.adjacents.add(adjacent);
			return false;
		}
	}

	public static int solution1(int n, int m, int[][] grid) {
		Node[][] graphedGrid = new Node[n][m];
		int largestGroup = 0;

		for (int y = 0; y < graphedGrid.length; y++) {
			for (int x = 0; x < graphedGrid[y].length; x++) {
				if (grid[y][x] == 1) {
					graphedGrid[y][x] = new Node();

					for (int yOffset = -1; yOffset <= 1; yOffset++) {
						for (int xOffset = -1; xOffset <= 1; xOffset++) {
							int newY = y + yOffset;
							int newX = x + xOffset;
							if ((newY >= 0 && newY < graphedGrid.length)
									&& (newX >= 0 && newX < graphedGrid[newY].length)) {
								if (!(x == newX && y == newY)) {
									if (graphedGrid[newY][newX] != null)
										graphedGrid[y][x].connectTo(graphedGrid[newY][newX]);
								}
							}
						}
					}
				}
			}
		}

		visited = new HashSet<Node>();

		for (int y = 0; y < graphedGrid.length; y++) {
			for (int x = 0; x < graphedGrid[y].length; x++) {
				if (graphedGrid[y][x] != null) {
					int connectedNodes = countConnectedNodes(graphedGrid[y][x]);
					largestGroup = Math.max(connectedNodes, largestGroup);
				}
			}
		}

		return largestGroup;
	}

	private static HashSet<Node> visited = null;

	private static int countConnectedNodes(Node node) {
		if (visited.contains(node))
			return 0;
		visited.add(node);
		if (node.adjacents.isEmpty())
			return 1;
		int count = 1;

		for (Node child : node.adjacents) {
			count += countConnectedNodes(child);
		}
		return count;
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int m = in.nextInt();
			int grid[][] = new int[n][m];
			for (int grid_i = 0; grid_i < n; grid_i++) {
				for (int grid_j = 0; grid_j < m; grid_j++) {
					grid[grid_i][grid_j] = in.nextInt();
				}
			}
			System.out.println(solution1(n, m, grid));
		}
	}
}
