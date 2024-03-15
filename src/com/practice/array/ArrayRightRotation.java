package com.practice.array;

public class ArrayRightRotation {
    /**
     * 1, 2, 3, 4, 5
     * 3 2 1 5 4
     * 4 5 1 2 3
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int k = 2;
        rightRotate(arr, n, k);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void rightRotate(int[] arr, int n, int k) {
        while (k > 0) {
            int first = arr[n - 1];
            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = first;
            k--;
        }
    }

    /**
     * The rightRotateUsingReverse method is designed to rotate the elements of the array to the right by k steps using the reverse method.
     * Here's how it works:
     * 1. It calculates the effective number of rotations by taking the modulo of k with n. This is done to handle cases when k is greater than n.
     * 2. It then calls the reverse method to reverse the entire array.
     * 3. It then calls the reverse method to reverse the first k elements of the array.
     * 4. It then calls the reverse method to reverse the remaining n - k elements of the array.
     * This effectively rotates the elements of the array to the right by k steps.
     */

    private static void rightRotateUsingReverse(int[] nums, int n, int k) {
        k = k % n;  // To handle cases when k is greater than n
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /**
     * In the reverse method, we swap the elements at the start and end indices and then increment start and decrement end until start is no longer less than end.
     * This effectively reverses the elements in the array between the start and end indices.
     */

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
