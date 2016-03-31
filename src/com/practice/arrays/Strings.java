package com.practice.arrays;

import java.util.HashMap;

public class Strings {
	public static void main(String[] args) {
		
	}
	public static boolean canAPalindromeMade(String s) {
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (h.containsKey(c)) {
				h.put(c, h.get(c) + 1);
			} else
				h.put(c, 1);

		}
		boolean oneFound = false;
		if (s.length() % 2 == 0) {
			for (char i : h.keySet()) {
				if (h.get(i) % 2 != 0) {
					if (!oneFound) {
						oneFound = true;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
}
