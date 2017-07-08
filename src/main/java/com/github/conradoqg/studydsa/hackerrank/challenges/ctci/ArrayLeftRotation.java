package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.Scanner;

public class ArrayLeftRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		a = solution1(n, k, a);

		for (int i = 0; i < a.length; i++)
			System.out.print((i == 0 ? "" : " ") + a[i]);
		
		in.close();
	}

	public static int[] solution1(int n, int k, int a[]) {
		for (int kLoop = 0; kLoop < k; kLoop++) {
			int temp = a[0];
			for (int nLoop = 0; nLoop < n - 1; nLoop++) {
				a[nLoop] = a[nLoop + 1];
			}
			a[a.length - 1] = temp;
		}

		return a;
	}

	public static int[] solution2(int n, int k, int a[]) {
		int[] rotatedArray = new int[n];

		for (int i = 0; i < n; i++) {
			rotatedArray[i] = a[(i + k) % n];
		}

		return rotatedArray;
	}
}
