package com.practice.array;

import java.util.*;

public class TwoSum {

    //Sorting and Two-Pointers technique.
    /*
    Approach: A tricky approach to solve this problem can be to use the two-pointer technique.
    But for using two pointer technique, the array must be sorted.
    Once the array is sorted the two pointers can be taken which mark the beginning and end of the array respectively.
    If the sum is greater than the sum of those two elements, shift the right pointer to decrease the value of the required sum
    and if the sum is lesser than the required value, shift the left pointer to increase the value of the required sum.

    Let an array be {1, 4, 45, 6, 10, -8} and sum to find be 16
    After sorting the array
    A = {-8, 1, 4, 6, 10, 45}
    Now, increment ‘l’ when the sum of the pair is less than the required sum
    and decrement ‘r’ when the sum of the pair is more than the required sum.
    This is because when the sum is less than the required sum then to get the number which could increase the sum of pair,
    start moving from left to right(also sort the array) thus “l++” and vice versa.
    Initialize l = 0, r = 5
    A[l] + A[r] ( -8 + 45) > 16 => decrement r. Now r = 4
    A[l] + A[r] ( -8 + 10) increment l. Now l = 1
    A[l] + A[r] ( 1 + 10) increment l. Now l = 2
    A[l] + A[r] ( 4 + 10) increment l. Now l = 3
    A[l] + A[r] ( 6 + 10) == 16 => Found candidates (return 1)
     */

    /*
    Time Complexity: Depends on what sorting algorithm we use.
    If Merge Sort or Heap Sort is used then (-)(nlogn) in the worst case.
    If Quick Sort is used then O(n^2) in the worst case.
    Auxiliary Space: This too depends on sorting algorithm.
    The auxiliary space is O(n) for merge sort and O(1) for Heap Sort.
     */

    // Function to check if array has 2 elements
    // whose sum is equal to the given value
    static boolean hasArrayTwoCandidates(
            int[] A,
            int arr_size, int sum) {
        int l, r;

        /* Sort the elements */
        Arrays.sort(A);

        /* Now look for the two candidates
        in the sorted array*/
        l = 0;
        r = arr_size - 1;
        while (l < r) {
            if (A[l] + A[r] == sum)
                return true;
            else if (A[l] + A[r] < sum)
                l++;
            else // A[i] + A[j] > sum
                r--;
        }
        return false;
    }

    /*
    This problem can be solved efficiently by using the technique of hashing.
    Use a hash_map to check for the current array value x(let),
    if there exists a value target_sum-x which on adding to the former gives target_sum.
    This can be done in constant time. Let’s look at the following example.

    arr[] = {0, -1, 2, -3, 1}
    sum = -2
    Now start traversing:
    Step 1: For ‘0’ there is no valid number ‘-2’ so store ‘0’ in hash_map.
    Step 2: For ‘-1’ there is no valid number ‘-1’ so store ‘-1’ in hash_map.
    Step 3: For ‘2’ there is no valid number ‘-4’ so store ‘2’ in hash_map.
    Step 4: For ‘-3’ there is no valid number ‘1’ so store ‘-3’ in hash_map.
    Step 5: For ‘1’ there is a valid number ‘-3’ so answer is 1, -3

    Time Complexity: O(n).
    As the whole array is needed to be traversed only once.
    Auxiliary Space: O(n).
    A hash map has been used to store array elements.
     */
    public static boolean checkPairs(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(sum - i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 45, 6, 10, -8};
        int n = 16;
        int arr_size = A.length;

        if (hasArrayTwoCandidates(A, arr_size, n))
            System.out.println("Array has two elements with given sum");
        else
            System.out.println("Array doesn't have two elements with given sum");

        System.out.println("Pair present->" + checkPairs(A, n));

        System.out.println("index -> "+ Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
