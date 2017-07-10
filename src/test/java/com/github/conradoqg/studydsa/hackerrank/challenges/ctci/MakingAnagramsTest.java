package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.*;

import org.junit.Test;

public class MakingAnagramsTest {

	@Test
	public void testNumberNeeded_Case1() {
		assertTrue(MakingAnagrams.numberNeeded("cde", "abc") == 4);
	}

	@Test
	public void testNumberNeeded_Case2() {
		assertTrue(MakingAnagrams.numberNeeded("cde", "abca") == 5);
	}
	
	@Test
	public void testNumberNeeded_Case3() {
		assertTrue(MakingAnagrams.numberNeeded("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke") == 30);
	}
	
/*	a = 1 -3 +3
	b = 1
	c = 1
	5
	
	abc
	aaaa
	
	a = 4 3
	b = 1
	c = 1
	4
	
	aaaa
	abc
	
	a = 1 0
	b = 1 0
	c = 1
	d = -1
	2
	
	abc
	abd
	
	c = 1 0
	d = 1
	e = 1
	a = -1 -2
	b = -1
	5
	
	cde
	abca*/
}
