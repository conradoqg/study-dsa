package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.Scanner;

public class MergeSort {

	private static long swapCount = 0;

	public static long mergeSort(int[] array) {
		swapCount = 0;
		mergeSort(array, new int[array.length], 0, array.length - 1);
		return swapCount;
	}

	private static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd)
			return;

		int middle = (leftStart + rightEnd) / 2;
		mergeSort(array, temp, leftStart, middle);
		mergeSort(array, temp, middle + 1, rightEnd);
		mergeHalves(array, temp, leftStart, middle, rightEnd);
	}

	private static void mergeHalves(int[] array, int[] temp, int leftStart, int middle, int rightEnd) {
		int leftIndex = leftStart;
		int rightIndex = middle + 1;
		int index = leftStart;

		for (int i = leftStart; i <= rightEnd; i++) {
			temp[i] = array[i];
		}

		while (leftIndex <= middle && rightIndex <= rightEnd) {
			if (temp[leftIndex] <= temp[rightIndex]) {
				array[index++] = temp[leftIndex++]; 
			} else {
				swapCount += middle + 1 - leftIndex;
				array[index++] = temp[rightIndex++];
			}
		}
		
		while (leftIndex <= middle) {
			array[index++] = temp[leftIndex++];
		}

	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			for (int a0 = 0; a0 < t; a0++) {
				int n = in.nextInt();
				int arr[] = new int[n];
				for (int arr_i = 0; arr_i < n; arr_i++) {
					arr[arr_i] = in.nextInt();
				}
				System.out.println(mergeSort(arr));
			}
		}
	}
}
