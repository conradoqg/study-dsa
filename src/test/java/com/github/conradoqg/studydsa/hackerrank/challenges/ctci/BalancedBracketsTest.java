package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class BalancedBracketsTest {
	static HashMap<Character, Character> brackets = new HashMap<Character, Character>();
	static HashMap<Character, Character> invertedBrackets = new HashMap<Character, Character>();

	@BeforeClass
	public static void setupClass() {
		brackets.put('{', '}');
		brackets.put('[', ']');
		brackets.put('(', ')');

		for (Map.Entry<Character, Character> entry : brackets.entrySet()) {
			invertedBrackets.put((char)entry.getValue(), (char)entry.getKey());
		}
	}

	@Test
	public void testIsBalanced_Case1() {
		assertTrue(BalancedBrackets.isBalanced("{[()]}"));
	}

	@Test
	public void testIsBalanced_Case2() {
		assertFalse(BalancedBrackets.isBalanced("{[(])}"));
	}

	@Test
	public void testIsBalanced_Case3() {
		assertTrue(BalancedBrackets.isBalanced("{{[[(())]]}}"));
	}

	@Test
	public void testIsBalanced_Case4() {
		assertFalse(BalancedBrackets.isBalanced("a{a{a[a[a(a(a)a)a]a]a}a}a"));
	}

	@Test
	public void testIsBalanced_Case5() {
		assertTrue(BalancedBrackets.isBalanced("{{{{{}}}}}"));
	}

	@Test
	public void testIsBalanced_Case6() {
		assertFalse(BalancedBrackets.isBalanced("{{{{{}}}}"));
	}
}
