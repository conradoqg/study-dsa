package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.HashMap;
import java.util.Scanner;

public class DavisStaircase {
    private static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    private static int calculateCombinatoryFor(int n) {
        int ways = 0;
        if (n == 1)
            ways = 1;
        if (n == 2)
            ways = 2;
        if (n == 3)
            ways = 4;

        if (n > 3) {
            for (int i = 1; i <= 3; i++) {
                if (cache.containsKey(n - i))
                    ways += cache.get(n - i);
                else {
                    int result = calculateCombinatoryFor(n - i);
                    ways += result;
                    cache.put(n - i, result);
                }
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int s = in.nextInt();
            for (int a0 = 0; a0 < s; a0++) {
                int n = in.nextInt();
                System.out.println(calculateCombinatoryFor(n));
            }
        }
    }
}
