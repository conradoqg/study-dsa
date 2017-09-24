package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.HashMap;
import java.util.Scanner;

public class CoinChange {
    public static long makeChange(int[] coins, int n) {
        if (n < 0) {
            return 0;
        }
        return makeChange(coins, n, 0, new HashMap<String, Long>());
    }

    public static long makeChange(int[] coins, int n, int coinNumber, HashMap<String, Long> cache) {
        String key = n + "," + coinNumber;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (coinNumber == coins.length - 1) {
            if (n % coins[coinNumber] == 0) {
                cache.put(key, 1L);
                return 1;
            } else {
                cache.put(key, 0L);
                return 0;
            }
        }

        long ways = 0;
        for (int i = 0; i <= n; i += coins[coinNumber]) {
            ways += makeChange(coins, n - i, coinNumber + 1, cache);
        }

        cache.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] coins = new int[m];
            for (int i = 0; i < m; i++) {
                coins[i] = scan.nextInt();
            }
            scan.close();

            System.out.println(makeChange(coins, n));
        }
    }
}
