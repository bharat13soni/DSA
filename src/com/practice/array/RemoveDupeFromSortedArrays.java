package com.practice.array;


import java.util.Arrays;

public class RemoveDupeFromSortedArrays {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int size = removeDuplicates(nums);
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println("Unique elements size -> " + size);
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;

        // To store index of next unique element
        int j = 0;

        // maintaining another updated index i.e. j
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] != nums[i + 1])
                nums[j++] = nums[i];

        // Store the last element as whether it is unique or
        // repeated, it hasn't stored previously
        nums[j++] = nums[nums.length - 1];

        return j;
    }
}
