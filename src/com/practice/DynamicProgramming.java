package com.practice;

public class DynamicProgramming {

    public static void main(String[] args) {
        int[] ints = {1, 3, 2};
        System.out.println(shortestPathToSum(ints, 8+1));
    }

    public static int findCloserSum(int[] a, int k) {
        int min = minimum(a);
        int[] M = new int[k];
        for (int i = 0; i < min; i++) {
            M[i] = 0;
        }
        for (int sum = min; sum < k; sum++) {
            int max = Integer.MIN_VALUE;
            for (int i : a) {
                if (i <= sum) {
                    int s = i + M[sum - i];
                    if (s > max)
                        max = s;
                    if (max == sum) {
                        break;
                    }
                }
            }
            M[sum] = max;
        }
        return M[k - 1];
    }

    public static int shortestPathToSum(int[] a, int k) {
        int min = minimum(a);
        if (k < min)
            return -1;
        int[] SP = new int[k];
        for (int i = 0; i < k; i++) {
            SP[i] = 999;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] < k)
                SP[a[i]] = 1;
        }
        for (int sum = min; sum < k; sum++) {
            for (int i : a) {
                if (i <= sum) {
                    if (SP[sum - i] != 999) {
                        if (SP[sum - i] + SP[i] < SP[sum]) {
                            SP[sum] = SP[sum - i] + SP[i];
                        }
                    }
                }
            }
        }
        return SP[k - 1];
    }

    public static int minimum(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int i : a)
            if (i < min)
                min = i;
        return min;
    }

    public static int coinChange(int[] a, int k) {
        int min = minimum(a);
        int[] W = new int[k];
        for (int i = 0; i < min; i++)
            W[i] = 0;

        for (int sum = min; sum < k; sum++) {
            for (int i : a) {
                if (i == sum) {
                    W[sum] += 1;
                    continue;
                }
                if (i < sum && W[sum - i] != 0) {
                    W[sum] += 1 + W[i];
                }
            }
        }
        return W[k - 1];
    }


}