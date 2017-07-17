package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IceCreamParlorTest {

	@Test
	public void testFindSumEquals_Case1() {
		int[] array = { 1, 4, 5, 3, 2 };
		int sum = 4;
		IceCreamParlor.ItemCombination foundCombination = IceCreamParlor.findSumEquals(array, sum);
		assertTrue(foundCombination.left.id == 1);
		assertTrue(foundCombination.right.id == 4);
	}

	@Test
	public void testFindSumEquals_Case2() {
		int[] array = { 230, 863, 916, 585, 981, 404, 316, 785, 88, 12, 70, 435, 384, 778, 887, 755, 740, 337, 86, 92,
				325, 422, 815, 650, 920, 125, 277, 336, 221, 847, 168, 23, 677, 61, 400, 136, 874, 363, 394, 199, 863,
				997, 794, 587, 124, 321, 212, 957, 764, 173, 314, 422, 927, 783, 930, 282, 306, 506, 44, 926, 691, 568,
				68, 730, 933, 737, 531, 180, 414, 751, 28, 546, 60, 371, 493, 370, 527, 387, 43, 541, 13, 457, 328, 227,
				652, 365, 430, 803, 59, 858, 538, 427, 583, 368, 375, 173, 809, 896, 370, 789 };
		int sum = 542;
		IceCreamParlor.ItemCombination foundCombination = IceCreamParlor.findSumEquals(array, sum);
		assertTrue(foundCombination.left.id == 29);
		assertTrue(foundCombination.right.id == 46);
	}

	@Test
	public void testFindSumEquals_Case3() {
		int[] array = { 1, 4, 5, 3, 2 };
		int sum = 4;
		IceCreamParlor.ItemCombination foundCombination = IceCreamParlor.findSumEqualsJavaBinary(array, sum);
		assertTrue(foundCombination.left.id == 1);
		assertTrue(foundCombination.right.id == 4);
	}

	@Test
	public void testFindSumEquals_Case4() {
		int[] array = { 230, 863, 916, 585, 981, 404, 316, 785, 88, 12, 70, 435, 384, 778, 887, 755, 740, 337, 86, 92,
				325, 422, 815, 650, 920, 125, 277, 336, 221, 847, 168, 23, 677, 61, 400, 136, 874, 363, 394, 199, 863,
				997, 794, 587, 124, 321, 212, 957, 764, 173, 314, 422, 927, 783, 930, 282, 306, 506, 44, 926, 691, 568,
				68, 730, 933, 737, 531, 180, 414, 751, 28, 546, 60, 371, 493, 370, 527, 387, 43, 541, 13, 457, 328, 227,
				652, 365, 430, 803, 59, 858, 538, 427, 583, 368, 375, 173, 809, 896, 370, 789 };
		int sum = 542;
		IceCreamParlor.ItemCombination foundCombination = IceCreamParlor.findSumEqualsJavaBinary(array, sum);
		assertTrue(foundCombination.left.id == 29);
		assertTrue(foundCombination.right.id == 46);
	}
	
	@Test
	public void testFindSumEquals_Case5() {
		int[] array = { 1, 4, 5, 3, 2 };
		int sum = 4;
		IceCreamParlor.ItemCombination foundCombination = IceCreamParlor.findSumEqualsCustomBinary(array, sum);
		assertTrue(foundCombination.left.id == 1);
		assertTrue(foundCombination.right.id == 4);
	}

	@Test
	public void testFindSumEquals_Case6() {
		int[] array = { 230, 863, 916, 585, 981, 404, 316, 785, 88, 12, 70, 435, 384, 778, 887, 755, 740, 337, 86, 92,
				325, 422, 815, 650, 920, 125, 277, 336, 221, 847, 168, 23, 677, 61, 400, 136, 874, 363, 394, 199, 863,
				997, 794, 587, 124, 321, 212, 957, 764, 173, 314, 422, 927, 783, 930, 282, 306, 506, 44, 926, 691, 568,
				68, 730, 933, 737, 531, 180, 414, 751, 28, 546, 60, 371, 493, 370, 527, 387, 43, 541, 13, 457, 328, 227,
				652, 365, 430, 803, 59, 858, 538, 427, 583, 368, 375, 173, 809, 896, 370, 789 };
		int sum = 542;
		IceCreamParlor.ItemCombination foundCombination = IceCreamParlor.findSumEqualsCustomBinary(array, sum);
		assertTrue(foundCombination.left.id == 29);
		assertTrue(foundCombination.right.id == 46);
	}
	
	@Test
	public void testFindSumEquals_Case7() {
		int[] array = { 5, 75, 25 };
		int sum = 100;
		IceCreamParlor.ItemCombination foundCombination = IceCreamParlor.findSumEqualsCustomBinary(array, sum);
		assertTrue(foundCombination.left.id == 2);
		assertTrue(foundCombination.right.id == 3);
	}
	
	@Test
	public void testFindSumEquals_Case8() {
		int[] array = { 150,24,79,50,88,345,3 };
		int sum = 200;
		IceCreamParlor.ItemCombination foundCombination = IceCreamParlor.findSumEqualsCustomBinary(array, sum);
		assertTrue(foundCombination.left.id == 1);
		assertTrue(foundCombination.right.id == 4);
	}
	
	@Test
	public void testFindSumEquals_Case9() {
		int[] array = { 2, 1, 9, 4, 4, 56, 90, 3 };
		int sum = 8;
		IceCreamParlor.ItemCombination foundCombination = IceCreamParlor.findSumEqualsJavaBinary(array, sum);
		assertTrue(foundCombination.left.id == 4);
		assertTrue(foundCombination.right.id == 5);
	}
}
