package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTheRunningMedian {
	static class RunningMedian {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		public void add(int value) {
			if (maxHeap.isEmpty()) {
	            maxHeap.add(value);
	        } else if (maxHeap.size() == minHeap.size()) {
	            if (value < minHeap.peek()) {
	                maxHeap.add(value);
	            } else {
	                minHeap.add(value);
	                maxHeap.add(minHeap.remove());
	            }
	        } else if (maxHeap.size() > minHeap.size()) {
	            if (value > maxHeap.peek()) {
	                minHeap.add(value);
	            } else {
	                maxHeap.add(value);
	                minHeap.add(maxHeap.remove());
	            }
	        }
		}
		
		public double getMedian() {
			if (maxHeap.size() ==0) return 0;
			if (maxHeap.size() > minHeap.size()) {
				return maxHeap.peek();
			} else {
				return (maxHeap.peek() + minHeap.peek()) / 2.0;
			}
		}
				
		@Override
		public String toString() {			
			return "Max: " + new StringBuilder(maxHeap.toString()).reverse().toString() + " - " + "Min: " + minHeap.toString();
		}
	}

	public static void main(String[] args) {
		RunningMedian median = new RunningMedian();
		
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();			
			for (int a_i = 0; a_i < n; a_i++) {				
				median.add(in.nextInt());
				System.out.println(median.getMedian());
			}
		}
	}
}
