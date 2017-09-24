package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.Scanner;

public class LonelyInteger {
    public static int lonelyInteger(int[] a) {
        int lonelyOne = 0;
        for (int nextNumber : a) {
            lonelyOne = lonelyOne ^ nextNumber;
        }
        return lonelyOne;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            System.out.println(lonelyInteger(a));
        }
    }
}
