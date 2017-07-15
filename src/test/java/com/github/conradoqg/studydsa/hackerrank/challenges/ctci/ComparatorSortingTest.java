package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ComparatorSortingTest {

	@Test
	public void testComparator_Case1() {
		ComparatorSorting.Player amy = new ComparatorSorting.Player("amy", 100);
		ComparatorSorting.Player david = new ComparatorSorting.Player("david", 100);
		ComparatorSorting.Player heraldo = new ComparatorSorting.Player("heraldo", 50);
		ComparatorSorting.Player aakansha = new ComparatorSorting.Player("aakansha", 75);
		ComparatorSorting.Player aleksa = new ComparatorSorting.Player("aleksa", 150);

		ComparatorSorting.Player[] players = {
				amy,
				david,
				heraldo,
				aakansha,
				aleksa
		};
		
		ComparatorSorting.Player[] playersSorted = {
				aleksa,
				amy,
				david,
				aakansha,
				heraldo
		};
		
		Arrays.sort(players, new ComparatorSorting.Checker());
		assertTrue(Arrays.equals(players, playersSorted));

	}

}
