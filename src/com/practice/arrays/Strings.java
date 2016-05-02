package com.practice.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class Strings {
    public static void main(String[] args) {
        System.out.println(isPalindromeAvailable("aaabbbb"));
    }

    public static String isPalindromeAvailable(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char prev = chars[0];
        for (char i : chars) {
            if (i == prev) {
                sb.insert(index++, i);
                continue;
            }
            prev = i;
            index = sb.length() / 2;
            sb.insert(index, i);
        }
        return sb.toString();
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

    //Sliding window
    public static String longestUniqueSubstring(String s) {
        //abcae
        String result = "";
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        String temp = "";
        while (j != n) {
            char key = s.charAt(j);
            if (map.containsKey(key)) {
                i = map.get(key) + 1;
            }
            if (j + 1 > n)
                temp = s.substring(i);
            else
                temp = s.substring(i, j + 1);
            if (temp.length() > result.length())
                result = temp;
            map.put(key, j);
            j++;
        }

        return result;
    }

    public static int deletion(String s) {
        int deletions = 0;
        int i = 0;
        int len = s.length();
        char prev = s.charAt(i);
        i++;
        while (i < len) {

            if (s.charAt(i) == prev) {
                deletions++;
                i++;
                continue;
            }
            prev = s.charAt(i);
            i++;

        }
        return deletions;
    }

}
