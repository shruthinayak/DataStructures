package com.practice.search;

import com.practice.CommonData;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by shruthi on 29/11/15.
 */
public class BinarySearch {
	static int[] a = CommonData.array;

	public static void main(String[] args) {
		binarySearch(a, a[3]);
		binaryRecursive(a, 0, a.length, a[3]);
	}

	public static void binarySearch(int[] a, int key) {
		int s = 0;
		int e = a.length;
		int mid = (s + e) / 2;
		System.out.println(Arrays.toString(a));

		while (s <= e) {

			if (a[mid] == key) {
				System.out.println("NonRecursive - Index: " + mid);
				return;
			} else if (a[mid] > key) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}

			mid = (s + e) / 2;
		}
		System.out.println("NonRecursive - Not found");

	}

	public static void binaryRecursive(int[] a, int s, int e, int key) {
		if (s <= e) {
			int mid = (s + e) / 2;
			if (a[mid] == key) {
				System.out.println("Recursive - Index: " + mid);
				return;
			} else if (key < a[mid]) {
				binaryRecursive(a, s, mid - 1, key);
			} else {
				binaryRecursive(a, mid + 1, e, key);
			}
		} else {
			System.out.println("Recursive - Not Found");
			return;
		}
	}

	/*
	 * Complete the function below.
	 */

	/*
	 * Complete the function below.
	 */

	/*
	 * Complete the function below.
	 */

	static String[] Braces(String[] values) {

		String[] output = new String[values.length];
		int count = 0;
		Stack<Character> stack = new Stack<Character>();
		for (String str : values) {
			boolean yes = true;

			if (str.isEmpty()) {
				yes = true;
			} else {

				stack = new Stack<Character>();
				for (int i = 0; i < str.length(); i++) {
					char current = str.charAt(i);
					if (current == '{' || current == '(' || current == '[') {
						stack.push(current);
					}

					if (current == '}' || current == ')' || current == ']') {
						if (stack.isEmpty()) {
							yes = false;
							break;
						}

						char last = stack.peek();
						if (current == '}' && last == '{' || current == ')'
								&& last == '(' || current == ']' && last == '[')
							stack.pop();
						else {
							yes = false;
							break;
						}
					}

				}
			}
			if (yes && stack.isEmpty()) {
				output[count] = "YES";
			} else
				output[count] = "NO";
			count++;
		}
		return output;
	}
}
