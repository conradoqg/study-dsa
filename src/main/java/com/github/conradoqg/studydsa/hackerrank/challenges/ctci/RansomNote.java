package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
	
	public static boolean canRansomUseMagazineWords(String[] magazine, String[] ransom) {
		Map<String, Integer> avaliableWords = new HashMap<String, Integer>();
		
		for (String magazineWord: magazine) {
			if (avaliableWords.containsKey(magazineWord)) avaliableWords.put(magazineWord, avaliableWords.get(magazineWord) + 1);
			else avaliableWords.put(magazineWord, 1);
		}
		
		for (String ransomWord: ransom) {
			if (avaliableWords.containsKey(ransomWord)) {
				int currentCount = avaliableWords.get(ransomWord);
				if (currentCount > 0)
					avaliableWords.put(ransomWord, currentCount-1);
				else
					return false;
			} else 
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int m = in.nextInt();
			int n = in.nextInt();
			String magazine[] = new String[m];
			for (int magazine_i = 0; magazine_i < m; magazine_i++) {
				magazine[magazine_i] = in.next();
			}
			String ransom[] = new String[n];
			for (int ransom_i = 0; ransom_i < n; ransom_i++) {
				ransom[ransom_i] = in.next();
			}
			
			System.out.println(canRansomUseMagazineWords(magazine, ransom) ? "Yes" : "No");
		}
	}

}
