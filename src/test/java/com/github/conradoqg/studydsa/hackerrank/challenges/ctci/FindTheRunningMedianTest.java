package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindTheRunningMedianTest {

	@Test
	public void test() {
		FindTheRunningMedian.RunningMedian runningMedia = new FindTheRunningMedian.RunningMedian();
		runningMedia.add(12);
		assertTrue(runningMedia.getMedian() == 12.0);
		runningMedia.add(4);
		assertTrue(runningMedia.getMedian() == 8.0);
		runningMedia.add(5);
		assertTrue(runningMedia.getMedian() == 5.0);
		runningMedia.add(3);
		assertTrue(runningMedia.getMedian() == 4.5);
		runningMedia.add(8);
		assertTrue(runningMedia.getMedian() == 5.0);
		runningMedia.add(7);
		assertTrue(runningMedia.getMedian() == 6.0);
		
		System.out.println(runningMedia.toString());
	}

}
