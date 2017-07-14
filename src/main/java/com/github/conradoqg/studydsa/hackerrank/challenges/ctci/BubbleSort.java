package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.Scanner;

public class BubbleSort {

	static int totalSwaps = 0;

	public static int[] sort(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			int numberOfSwaps = 0;
			// Track number of elements swapped during a single array traversal
			for (int j = 0; j < n - 1; j++) {
				// Swap adjacent elements if they are in decreasing order
				if (a[j] > a[j + 1]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
					numberOfSwaps++;
				}
			}

			totalSwaps += numberOfSwaps;

			// If no elements were swapped during a traversal, array is sorted
			if (numberOfSwaps == 0) {
				break;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int a[] = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			a = sort(a, n);

			System.out.println(String.format("Array is sorted in %d swaps.", totalSwaps));
			System.out.println(String.format("First Element: %d", a[0]));
			System.out.println(String.format("Last Element: %d", a[a.length - 1]));
		}
	}

}
