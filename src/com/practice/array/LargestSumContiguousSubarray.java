package com.practice.array;

public class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        int[] a = {5, -4, -2, 6, -1};
        System.out.println(maxSumSubarray(a));
    }

    //Kadane's Algorithm
    public static int maxSumSubarray(int[] a) {
        int currSum = 0;
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            currSum += a[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
