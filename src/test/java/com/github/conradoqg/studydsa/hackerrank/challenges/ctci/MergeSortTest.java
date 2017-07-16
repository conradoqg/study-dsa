package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testMergeSort_Case1() {
		int[] array = { 1, 1, 1, 2, 2};
		int[] orderedArray = { 1, 1, 1, 2, 2};
		
		assertTrue(MergeSort.mergeSort(array)==0);
		assertTrue(Arrays.equals(array, orderedArray));
	}
	
	@Test
	public void testMergeSort_Case2() {
		int[] array = { 2, 1, 3, 1, 2};
		int[] orderedArray = { 1, 1, 2, 2, 3};
		
		assertTrue(MergeSort.mergeSort(array)==4);
		assertTrue(Arrays.equals(array, orderedArray));
	}

}
