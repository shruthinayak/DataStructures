package com.practice.arrays;

import com.practice.CommonData;

import java.util.*;

public class GeeksForGeeks {

    static int[] array = CommonData.array;
    static int[] d;

    public static void main(String[] args) {
        /*int[][] a = {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        System.out.println(friendCircle(a));*/
        getSpecialPageNumbers(new int[]{4, 2, 6, 1, 10}, 5, 3);
    }

    public static void getSpecialPageNumbers(int[] problems, int n, int k) {
        int pageNumber = 1;
        int chap = 1;
        int special = 0;
        while (chap <= n) {
            int end = 1;
            int start = 1;

            while (end < problems[chap - 1]) {
                start = end;
                if (end + k - 1 <= problems[chap - 1]) {
                    end = end + k - 1;
                } else {
                    end = problems[chap - 1];
                }
                if (pageNumber >= start && pageNumber <= end) {
                    special++;
                }
                pageNumber++;
            }
            chap++;
        }
        System.out.println(special);
    }

    public static int friendCircle(int[][] matrix) {
        boolean[] visited = new boolean[matrix.length];
        int circles = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (!visited[i]) {
                circles++;
                int j = i + 1;
                while (j < matrix[0].length && matrix[i][j] == 1) {
                    visited[j] = true;
                    i = j;
                    j++;
                }
            }
        }

        return circles;
    }

    public static int nCents(int n) {
        if (d[n] != 0)
            return d[n];

        int tf = 0, ten = 0, five = 0, one = 0;
        tf = n - 25 >= 0 ? nCents(n - 25) : 0;
        ten = n - 10 >= 0 ? nCents(n - 10) : 0;
        five = n - 5 >= 0 ? nCents(n - 5) : 0;
        one = n - 1 >= 0 ? nCents(n - 1) : 0;
        System.out.println(one + ", " + five + ", " + ten + ", " + tf);
        d[n] = one + five + ten + tf;
        return d[n];
    }

    /**
     * Implement an algorithm to print all valid (e.g., properly opened and closed)
     * combinations of n-pairs of parentheses.
     *
     * @param n
     * @return
     */
    public static List<String> parenthesize(int n) {
        List<String> temp = new ArrayList<>();
        if (n == 1) {
            temp.add("()");
            return temp;
        }
        List<String> parenthesize = parenthesize(n - 1);

        for (String i : parenthesize) {
            temp.add("(" + i + ")");
            if (!("()" + i).equals(i + "()"))
                temp.add("()" + i);
            temp.add(i + "()");
        }
        return temp;
    }

    /**
     * Write a method to compute all permutations of a string
     *
     * @param index
     * @param s
     * @return
     */
    public static List<String> permutationsOfString(int index, String s) {
        List<String> temp = new ArrayList<>();
        if (s.length() - index == 1) {
            temp.add(s.substring(index));
            return temp;
        }
        String current = s.charAt(index) + "";
        List<String> permutation = permutationsOfString(index + 1, s);
        List<String> master = new ArrayList<>();
        master.add(current);
        for (String p : permutation) {
            master.add(p);
            master.add(p + current);
            master.add(current + p);
        }
        return master;
    }

    /**
     * Write a method that returns all subsets of a set.
     *
     * @param index
     * @param set
     * @return Returns all the subsets of a set.
     */
    public static List<List> subset(int index, List<Integer> set) {
        List<Integer> temp = new ArrayList<>();
        if (set.size() - index == 1) { //until one element is left in the subset
            List<List> letssee = new ArrayList<>();
            temp.add(set.get(index));
            letssee.add(temp);
            return letssee;
        }
        int i = set.get(index); //get the current number. Find the smaller subsets and then add i to all the subsets
        List<List> subsets = subset(index + 1, set);
        List<List> allSub = new ArrayList<>();
        temp.add(i);
        allSub.add(temp);
        for (List l : subsets) {
            allSub.add(l);
            temp = new ArrayList<>();
            temp.addAll(l);
            temp.add(i);
            allSub.add(temp);
        }

        return allSub;
    }

    /**
     * Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can
     * only move in two directions: right and down. How many possible paths are there for
     * the robot?
     *
     * @param row
     * @param col
     * @param gridSize
     * @return
     */
    static int totalPaths(int row, int col, int gridSize) {
        if (row == gridSize && col == gridSize)
            return 1;
        int right = 0, down = 0;
        if (col + 1 <= gridSize) {
            right = totalPaths(row, col + 1, gridSize);
        }
        if (row + 1 <= gridSize) {
            down = totalPaths(row + 1, col, gridSize);
        }
        return right + down;
    }

    /**
     * Write a method to generate the nth Fibonacci number.
     *
     * @param n
     * @return
     */
    static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int prev2 = 0;
        int prev1 = 1;
        int i = 2;
        while (i != n) {
            int result = prev2 + prev1;
            prev2 = prev1;
            prev1 = result;
            i++;
        }
        return prev1 + prev2;
    }

    /**
     * Comparator
     *
     * @param listToSortAlphabetically
     */
    public static void writingComparator(List<String> listToSortAlphabetically) {
        System.out.println(listToSortAlphabetically.toString());
        Comparator<String> sortAlphabetically = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int i = 0;

                System.out.println(o1 + "," + o2);
                o1 = o1.toLowerCase();
                o2 = o2.toLowerCase();
                int maxlen = o1.length() > o2.length() ? o2.length() : o1
                        .length();
                while ((o1.charAt(i) == o2.charAt(i)) && i < maxlen - 1) {
                    i++;
                }
                return o1.charAt(i) >= o2.charAt(i) ? 1 : -1;
            }
        };

        Collections.sort(listToSortAlphabetically, sortAlphabetically);
        System.out.println(listToSortAlphabetically.toString());
    }

    /**
     * From intArray given integer array values, find if intArray Total value is possible
     * or not? The numbers in the array can be used more than once.
     *
     * @param intArray
     * @param sum
     * @return
     */
    public static boolean isTotalPossible(int[] intArray, int sum) {

        int i = 0;
        int min = 999;
        for (int s : intArray) {
            if (s < min) {
                min = s;
            }
            if (s == sum) {
                return true;
            }
        }
        while (i != intArray.length) {
            if (sum - intArray[i] == 0) {
                return true;
            }
            if (sum - intArray[i] >= min) {
                System.out.println(intArray[i] + ", " + (sum - intArray[i]));
                return isTotalPossible(intArray, sum - intArray[i]);
            } else {
                i++;
            }
        }
        return false;
    }

    public static void dotProductOfSparseVectors(String[] input) {
        int m = Integer.parseInt(input[0].split(" ")[0]);
        int n = Integer.parseInt(input[0].split(" ")[1]);
        int sum = 0;
        HashMap<Integer, Integer> dotproduct = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            String g = input[i];
            dotproduct.put(Integer.parseInt(g.split(" ")[0]),
                    Integer.parseInt(g.split(" ")[1]));
        }
        for (int i = m + 1; i <= m + n; i++) {
            String g = input[i];
            int l = Integer.parseInt(g.split(" ")[0]);
            int k = Integer.parseInt(g.split(" ")[1]);
            if (dotproduct.containsKey(l)) {
                sum += dotproduct.get(l) * k;
            }

        }
        System.out.println("Dotproduct: " + sum);
    }

    /**
     * You have an array with words. Print them by anagrams groups
     *
     * @param words
     */
    public static void groupByAnagrams(String[] words) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (String i : words) {
            char[] c = i.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (anagrams.containsKey(key)) {
                anagrams.get(key).add(i);
            } else
                anagrams.put(key, new ArrayList<>(Arrays.asList(i)));
        }
        for (String i : anagrams.keySet()) {
            System.out.println("i: " + i);

            for (String j : anagrams.get(i))
                System.out.print(": " + j);

            System.out.println();
        }
    }

    /**
     * distinct pairs that add up to kSum
     *
     * @param intArray
     * @param kSum
     */
    public static void distinctPairsToK(int[] intArray, int kSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : intArray) {
            set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (set.contains(kSum - i)) {
                System.out.println(i + "," + (kSum - i));
                iterator.remove();
            }
        }

    }

    /**
     * @param a
     */
    public static void largestContiguousSubArray(int[] a) {
        int prevMax = 0;
        int sum = 0;
        int startIndex = -1;
        int start = -1;
        int endIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if (sum + a[i] < 0) {  //reset the sum to zero if negative encountered
                sum = 0;
                startIndex = i + 1;
            } else {
                sum = sum + a[i]; //else sum it up
                if (sum > prevMax) {
                    start = startIndex;
                    prevMax = sum;
                    endIndex = i;
                }
            }
        }
        System.out.println(start + ":" + endIndex);
    }

    public static void findMissingNumber(int[] a) {
        int n = a.length + 1;
        int sum = n * (n + 1) / 2;
        for (int i : a) {
            sum = sum - i;
        }
        System.out.println("Missing number: " + sum);
    }


    // Find subarray with given sum
    public static void subArraySum(int[] a, int k) {
        int first = a[0];
        int start = 0;
        int sum = first;
        int end = 0;
        for (int i = 1; i < a.length; i++) {
            end = i;

            if (sum == k) {
                System.out.println(start + ":" + end);
                break;
            } else if (sum > k) {
                sum = sum - first;
                start = start + 1;
                first = a[start];
            } else
                sum = sum + a[i];
        }
    }

    public static int kthLargest(int[] array, int k) {
        int p = 0;
        int r = array.length - 1;
        int q = -1;
        while (k != 0) {
            q = partition(p, r);
            System.out.println(k + ":" + q);
            if (k == q)
                return array[k];
            else if (k < q) {
                r = q - 1;
            } else if (k > q) {
                k = k - (q - p + 1);
                p = q + 1;
            }
        }
        return array[q];
    }

    public static int partition(int p, int r) {
        Random rand = new Random();

        int index = rand.nextInt(r);
        swap(index, r);
        int pivot = array[r];
        int i = p - 1;
        int j = 0;
        while (j != r) {
            if (array[j] < pivot) {
                i += 1;
                swap(i, j);
            }
            j++;
        }
        swap(i + 1, array[r]);
        return i + 1;
    }

    public static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * https://www.interviewcake.com/question/python/stock-price
     *
     * @param stockPrices
     * @return
     */
    public static int maximumProfit(int[] stockPrices) {
        int sum = 0;
        int maxSum = -999;
        int j = 1;
        int len = stockPrices.length;
        while (j < len) {
            sum = sum + (stockPrices[j] - stockPrices[j - 1]);
            if (sum < 0) {
                sum = 0;
            } else if (sum > maxSum) {
                maxSum = sum;
            }
            j++;
        }
        if (maxSum < 0)
            return 0;
        return maxSum;
    }
}
