package com.practice;

public class Solution1 {
    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int count = 1;
        int i = 0, j = i + 1;
        while (i < nums.length && j < nums.length) {
            if (nums[j] == nums[i]) {
                ++i;
                ++j;
            } else if (nums[j] > nums[i]) {
                ++count;
                int k = j + 1;
                while (k < nums.length && nums[k] >= nums[k - 1]) {
                    ++k;
                }
                if (k == nums.length)
                    return count;
                i = k - 1;
                j = k;
            } else {
                ++count;
                int k = j + 1;
                while (k < nums.length && nums[k] <= nums[k - 1]) {
                    ++k;
                }
                if (k == nums.length)
                    return count;
                i = k - 1;
                j = k;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(wiggleMaxLength(new int[]{2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5}));
        System.out.println(calculateCastles(new int[]{2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5}));
    }

    public static int calculateCastles(int[] A) {
        int N = A.length;
        if (N == 0) return 0;
        int count = 0;
        int prevValue = A[0];
        for(int idx = 1; idx < N - 1; idx++) {
            if(((A[idx] - prevValue) * (A[idx + 1] - A[idx])) < 0) {
                count++;
                prevValue = A[idx];
            }
        }
        if(count == 0){
            if(A[0] == A[N-1]) return 1;
            return 2;
        }
        return count + 2;
    }
}
