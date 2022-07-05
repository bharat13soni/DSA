package com.practice.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashingBasedProblems {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 6, 10, 3, 6};
        int[] b = {7, 9, 8, 6, 1};
        System.out.println("countDistinctElements ->" + countDistinctElements(a));
        System.out.println("unionOfArrays ->" + unionOfArrays(a, b));
        System.out.println("intersectionOfArrays ->" + intersectionOfArrays(a, b));
        subArraySum(b, 23);
        System.out.println("countDistinctElementsInWindow ->");
        countDistinctElementsInWindow(new int[]{1, 2, 2, 1, 3, 1, 1, 3}, 4);
    }

    public static int countDistinctElements(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        return set.size();
    }

    /*
    Count distinct elements in every window of size k
     */
    public static void countDistinctElementsInWindow(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //Handling for first window
        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        System.out.println(map.size());
        for (int i = k; i < a.length; i++) {
            //remove previous element that is not part of this window
            if (map.get(a[i - k]) == 1) {
                map.remove(a[i - k]);
            } else {
                map.put(a[i - k], map.get(a[i - k]) - 1);
            }
            //Addition of new element for the current window
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            System.out.println(map.size());
        }
    }

    public static int unionOfArrays(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : b) {
            set.add(i);
        }
        return set.size();
    }

    public static int intersectionOfArrays(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i : a) {
            set.add(i);
        }
        for (int i : b) {
            if (set.contains(i)) {
                count++;
                set.remove(i);
            }
        }
        return count;
    }

    public static void subArraySum(int[] a, int sum) {
        int currSum = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            currSum += a[i];
            if (currSum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            if (map.containsKey(currSum - sum)) {
                start = map.get(currSum - sum) + 1;
                end = i;
                break;
            }
            map.put(currSum, i);
        }
        if (end == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Subarray with given sum found ->" + start + ", " + end);
        }
    }
}
