package com.practice.array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 2, 0, 4};
        int n = arr.length;

//        System.out.print(maxWater(arr, n));
        System.out.print(findWater(arr, n));
    }

    // Function to return the maximum
    // water that can be stored
    //Time Complexity: O(n2) Space Complexity: O(1)
    public static int maxWater(int[] arr, int n) {
        int res = 0;

        // For every element of the array
        // except first and last element
        for (int i = 1; i < n - 1; i++) {

            // Find maximum element on its left
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }

            // Find maximum element on its right
            int rightMax = 0;
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }

            // Update maximum water value
            res += Math.min(leftMax, rightMax) - arr[i];
        }
        return res;
    }

    //Time Complexity: O(n). Space Complexity: O(n).
    static int findWaterUsingExtraArrays(int[] arr, int n) {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int[] left = new int[n];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int[] right = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }

        return water;
    }

    //Time Complexity: O(n). Auxiliary Space: O(1).
    static int findWater(int arr[], int n) {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int leftMax = 0, rightMax = 0;

        // indices to traverse the array
        int low = 0, high = n - 1;

        while (low <= high) {
            if (arr[low] < arr[high]) {
                if (arr[low] > leftMax) {
                    // update max in left
                    leftMax = arr[low];
                } else {
                    // water on curr element =
                    // max - curr
                    result += leftMax - arr[low];
                }
                low++;
            } else {
                if (arr[high] > rightMax) {
                    // update right maximum
                    rightMax = arr[high];
                } else {
                    result += rightMax - arr[high];
                }
                high--;
            }
        }

        return result;
    }
}
