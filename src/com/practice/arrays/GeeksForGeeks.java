package com.practice.arrays;

import com.practice.CommonData;

import java.util.*;

public class GeeksForGeeks {

    static int[] array = CommonData.array;

    public static void main(String[] args) {
        // largestContiguousSubArray(array);
        // findMissingNumber(array);]
        // subArraySum(array, 17);

        Random rand = new Random();
        int[] a = new int[100];
        for (int i = 1; i < 10; i++) {
            a[i] = 0 - rand.nextInt(100);
            System.out.print(a[i] + " ");
        }
        distinctPairsToK(a, 25);
        largestContiguousSubArray(a);


        int[] b = {2, 5};

        System.out.println("9 : " + isTotalPossible(b, 9));


        List<String> list = Arrays.asList("fds", "Dfa", "ferw", "asv", "DFaw");
        List<Integer> list1 = Arrays.asList(4, 3, 5, 7, 3, 2, 1);

        Collections.sort(list1);
        Collections.sort(list);
        System.out.println(list1.toString());
        System.out.println(list.toString());
        list = Arrays.asList("fds", "Dfa", "ferw", "asv", "DFaw");
        writingComparator(list);

    }


    public static void writingComparator(List<String> list) {
        System.out.println(list.toString());
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

        Collections.sort(list, sortAlphabetically);
        System.out.println(list.toString());
    }

    public static boolean isTotalPossible(int[] a, int k) {
        // From a given integer array values, find if a Total value is possible
        // or not? The numbers in the array can be used more than once.
        int i = 0;
        int min = 999;
        for (int s : a) {
            if (s < min) {
                min = s;
            }
            if (s == k) {
                return true;
            }
        }
        while (i != a.length) {
            if (k - a[i] == 0) {
                return true;
            }
            if (k - a[i] >= min) {
                System.out.println(a[i] + ", " + (k - a[i]));
                return isTotalPossible(a, k - a[i]);
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

    // You have an array with words. Print them by anagrams groups
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

    // distinct pairs that add up to k
    public static void distinctPairsToK(int[] a, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (set.contains(k - i)) {
                System.out.println(i + "," + (k - i));
                iterator.remove();
            }
        }

    }

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
                if (sum > prevMax) { //
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

    public static int kthLargest(int k) {
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

}
