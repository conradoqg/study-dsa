package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.HashMap;
import java.util.Scanner;

public class MakingAnagrams {
	public static int numberNeeded(String first, String second) {
		HashMap<Character, Integer> charAccBook = new HashMap<Character, Integer>();

		for (char c : first.toCharArray()) {
			if (charAccBook.containsKey(c))
				charAccBook.put(c, charAccBook.get(c) + 1);
			else
				charAccBook.put(c, 1);
		}

		int secondAccounting = 0;
		for (char c : second.toCharArray()) {
			if (charAccBook.containsKey(c))
				charAccBook.put(c, charAccBook.get(c) - 1);
			else
				charAccBook.put(c, -1);
		}

		int accounting = 0;
		for (Integer balance : charAccBook.values()) {
			accounting += Math.abs(balance);
		}

		return accounting + secondAccounting;
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String a = in.next();
			String b = in.next();
			System.out.println(numberNeeded(a, b));
		}
	}
}
