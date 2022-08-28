package com.practice.array;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void mergeArrays(int[] arr1, int[] arr2, int n1,
                                   int n2) {
        int[] mergedArray = new int[n1 + n2];
        int a1 = 0;
        int a2 = 0;
        int i = 0;
        // Check if current element of first
        // array is smaller than current element
        // of second array. If yes, store first
        // array element and increment first array
        // index. Otherwise, do same with second array
        while (i < mergedArray.length && a1 < n1 && a2 < n2) {
            if (arr1[a1] < arr2[a2]) {
                mergedArray[i++] = arr1[a1++];
            } else {
                mergedArray[i++] = arr2[a2++];
            }
        }

        // Store remaining elements of first array
        while (a1 < n1) {
            mergedArray[i++] = arr1[a1++];
        }

        // Store remaining elements of second array
        while (a2 < n2) {
            mergedArray[i++] = arr2[a2++];
        }
        System.out.println("Array after merging");

        System.out.println(Arrays.toString(mergedArray));

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int n1 = arr1.length;

        int[] arr2 = {2, 4, 6, 8};
        int n2 = arr2.length;
        mergeArrays(arr1, arr2, n1, n2);

    }
}
