package com.practice.array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
        /*int[] arr = {40, 13, 27, 87, 95, 40, 96, 71, 35, 79, 68, 2, 98, 3, 18, 93, 53, 57, 2, 81, 87, 42, 66, 90, 45, 20, 41, 30, 32, 18, 98, 72, 82, 76, 10, 28, 68, 57, 98, 54, 87, 66, 7, 84, 20, 25, 29, 72, 33, 30, 4, 20, 71, 69, 9, 16, 41, 50, 97, 24, 19, 46, 47, 52, 22, 56, 80, 89, 65, 29, 42, 51, 94, 1, 35, 65, 25};
        rotateArr(arr, 69, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }*/

        int[] nums = {1, 2, 3};
        rotateArrayRightByK(nums, 4);
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
    }

    //Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d, int n) {
        reverseArr(arr, 0, d - 1);
        reverseArr(arr, d, n - 1);
        reverseArr(arr, 0, n - 1);
    }

    private static void reverseArr(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
//        arr[i1] = arr[i1] + arr[i2];
//        arr[i2] = arr[i1] - arr[i2];
//        arr[i1] = arr[i1] - arr[i2];
    }

    /**
     * Approach: The approach is simple yet optimized.
     * The idea is to reverse the array three times.
     * Time Complexity: O(N).
     * Auxiliary Space: O(1).
     *
     * // Reduce the number of rotations
     *    k = k % n
     *
     *    // Reverse the first part of the array
     *    reverse(arr, arr + n – k)
     *
     *    // Reverse the second part of the array
     *    reverse(arr + n – k, arr + n)
     *
     *    // Reverse the entire array
     *    reverse(arr, arr + n)
     */
    static void rotateArrayRightByK(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1 || nums.length == k) {
            return;
        }
        //change k if k is greater than nums.length
        if (k > nums.length) {
            k = (k % nums.length);
        }
        reverseArr(nums, 0, nums.length - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, nums.length - 1);
    }
}
