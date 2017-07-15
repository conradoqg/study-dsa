package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ComparatorSorting {
	public static class Checker implements Comparator<Player> {

		@Override
		public int compare(Player o1, Player o2) {
			if (o1.score > o2.score)
				return -1;
			else if (o1.score < o2.score)
				return 1;
			else if (o1.score == o2.score) {				
				if (o1.name.compareTo(o2.name) > 0)
					return 1;
				else
					return -1;
			}
			return 0;
		}
		
	}
	
	public static class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int n = scan.nextInt();

			Player[] player = new Player[n];
			Checker checker = new Checker();

			for (int i = 0; i < n; i++) {
				player[i] = new Player(scan.next(), scan.nextInt());
			}
			scan.close();

			Arrays.sort(player, checker);
			for (int i = 0; i < player.length; i++) {
				System.out.printf("%s %s\n", player[i].name, player[i].score);
			}
		}
	}
}
