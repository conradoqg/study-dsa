package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.Scanner;

public class Primality {
    public static boolean isPrime(int number) {
        // Number 0, 1 are not prime
        if (number < 2) return false;
        
        int squareRoot = (int) Math.sqrt(number);
        for (int testNumber = 2; testNumber <= squareRoot; testNumber++) {
            if (number % testNumber == 0) return false;            
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int p = in.nextInt();
            for (int a0 = 0; a0 < p; a0++) {
                int n = in.nextInt();
                System.out.println(isPrime(n) ? "Prime" : "Not prime");
            }
        }        
    }
}
