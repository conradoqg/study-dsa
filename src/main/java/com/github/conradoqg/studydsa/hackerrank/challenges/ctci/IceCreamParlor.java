package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class IceCreamParlor {

	public static class ItemCombination {
		Item left;
		Item right;

		public ItemCombination() {
		}

		public ItemCombination(Item left, Item right) {
			this.left = left;
			this.right = right;
		}
	}

	public static class Item implements Comparable<Item> {
		int id;
		int value;

		public Item(int id, int value) {
			this.id = id;
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			return this.value == ((Item) obj).value;
		}

		@Override
		public int compareTo(Item o) {
			return (this.value - o.value);
		}
	}

	public static ItemCombination findSumEquals(int[] array, int sum) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == sum) {
					ItemCombination itemCombination = new ItemCombination();
					if (i < j) {
						itemCombination.left = new Item(i + 1, array[i]);
						itemCombination.right = new Item(j + 1, array[j]);
					} else {
						itemCombination.left = new Item(j + 1, array[j]);
						itemCombination.right = new Item(i + 1, array[i]);
					}
					return itemCombination;
				}
			}
		}
		return null;
	}

	static ItemCombination findSumEqualsJavaBinary(int[] array, int value) {
		return findSumEqualsBinary(array, value, Arrays::binarySearch);
	}

	static ItemCombination findSumEqualsCustomBinary(int[] array, int value) {
		return findSumEqualsBinary(array, value, IceCreamParlor::binarySearch);
	}

	static <T extends Comparable<T>> ItemCombination findSumEqualsBinary(int[] array, int value,
			BiFunction<T[], T, Integer> binarySearchFunc) {
		Item[] items = new Item[array.length];
		for (int i = 0; i < array.length; i++) {
			items[i] = new Item(i + 1, array[i]);
		}

		Arrays.sort(items);

		for (int i = 0; i < items.length; i++) {
			@SuppressWarnings("unchecked")
			Integer result = binarySearchFunc.apply((T[]) items, ((T) new Item(0, value - items[i].value)));

			if (result >= 0) {
				if (items[i].id < items[result].id)
					return new ItemCombination(items[i], items[result]);
				else
					return new ItemCombination(items[result], items[i]);
			}
		}
		return null;
	}

	public static <T extends Comparable<T>> int binarySearch(T[] array, T key) {
		return binarySearch(array, key, 0, array.length - 1);
	}

	static <T extends Comparable<T>> int binarySearch(T[] array, T key, int start, int end) {
		if (start > end)
			return -1;

		int mid = (start + end) / 2;
		int result = array[mid].compareTo(key);
		if (result > 0) {
			return binarySearch(array, key, start, mid - 1);
		} else if (result < 0) {
			return binarySearch(array, key, mid + 1, end);
		} else if (result == 0) {
			return mid;
		}

		return -1;
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			for (int a0 = 0; a0 < t; a0++) {
				int m = in.nextInt();
				int n = in.nextInt();
				int a[] = new int[n];
				for (int a_i = 0; a_i < n; a_i++) {
					a[a_i] = in.nextInt();
				}
				ItemCombination foundItem = findSumEquals(a, m);
				System.out.println(String.valueOf(foundItem.left.id) + " " + String.valueOf(foundItem.right.id));
			}
		}
	}
}
