package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.*;

import org.junit.Test;

public class RansomNoteTest {

	@Test
	public void testCanRansomUseMagazineWords_Case1() {
		String[] magazine = {"give", "me", "one", "grand", "today", "night"};
		String[] ransom = {"give", "one", "grand", "today"};
		assertTrue(RansomNote.canRansomUseMagazineWords(magazine, ransom));
	}
	
	@Test
	public void testCanRansomUseMagazineWords_Case2() {
		String[] magazine = {"two", "times", "three", "is", "not", "four"};
		String[] ransom = {"two", "times", "two", "is", "four"};
		assertFalse(RansomNote.canRansomUseMagazineWords(magazine, ransom));
	}

}
