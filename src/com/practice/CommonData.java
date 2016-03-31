package com.practice;

import java.util.Random;

/**
 * Created by shruthi on 29/11/15.
 */
public class CommonData {
	public static int[] array = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };
	public static int[] unsorted = { 2, 3, 1, 4, 11, 453, 464, 234, 13, 7, 14,
			9, 10 };

	public static int[] getUnsortedArray(int size) {
		Random rand = new Random();
		unsorted = new int[size];
		for (int i = 0; i <  size; i++) {
			unsorted[i] = rand.nextInt(100);
		}
		return unsorted;
	}
}
