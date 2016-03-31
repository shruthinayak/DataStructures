package com.practice.sort;

import com.practice.CommonData;

import java.util.Arrays;

/**
 * Created by shruthi on 29/11/15.
 */
public class MergeSort {
    static int[] array = CommonData.getUnsortedArray(20);
    static int[] tempMergArr = new int[array.length];
    public static void main(String[] args){
        System.out.println(Arrays.toString(array));
        doMergeSort(0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
    private static void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private static void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
        while (j <= higherIndex) {
            array[k] = tempMergArr[j];
            k++;
            j++;
        }

    }
    public static void mergeSort(int[] a, int s, int e) {

        if (s <= e) {
            int mid = (s + e) / 2;
            mergeSort(a, s, mid - 1);
            mergeSort(a, mid + 1, e);
            merge(a, s, mid, e);
        }
    }

    public static int[] merge(int[] a, int s, int mid, int e) {

        int m = mid - s + 1;
        int n = e - mid + 1;
        int[] c = new int[m];
        int[] d = new int[n];
        int[] b = new int[m + n];
        int i = s, j=mid+1, k=0;
        while (i < mid && j < e) {
            if (a[i] <= a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            b[k] = a[i];
            i++;
            k++;
        }
        while (j < e) {
            b[k] = a[j];
            k++;
            j++;
        }
        System.out.println(Arrays.toString(b));
        return b;
    }
}
