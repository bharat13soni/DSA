package com.practice.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckArraysEquality {
    public static void main(String[] args) {
//        boolean arraysEqual = arraysEqual(new int[]{1, 2, 5, 4, 0}, new int[]{2, 4, 5, 0, 1});
        boolean arraysEqual = arraysEqualUsingHashing(new int[]{1, 2, 5, 4, 0}, new int[]{2, 4, 5, 0, 1});
        System.out.println("arraysEqual -> " + arraysEqual);
    }

    //Time Complexity: O(n log n)
    //Auxiliary Space: O(1)
    public static boolean arraysEqual(int arr1[], int arr2[]) {
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //Time Complexity: O(n)
    //Auxiliary Space: O(n)
    public static boolean arraysEqualUsingHashing(int arr1[], int arr2[]) {
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();

        // Store arr1[] elements and their counts in hashmap
        for (int j : arr1) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else {
                map.put(j, map.get(j) + 1);
            }
        }

        // Traverse arr2[] elements and check if all
        // elements of arr2[] are present same number
        // of times or not.
        for (int i : arr2) {
            // If there is an element in arr2[], but
            // not in arr1[]
            if (!map.containsKey(i))
                return false;

            // If an element of arr2[] appears more
            // times than it appears in arr1[]
            if (map.get(i) == 0)
                return false;
            Integer count = map.get(i);
            map.put(i, --count);
        }
        return true;
    }
}
