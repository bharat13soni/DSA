package com.practice.array;

import java.util.Arrays;

public class Sort012 {
    public static void main(int[] a) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int j : a) {
            switch (j) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + j);
            }
        }
        int i = 0;
        while (count0 > 0) {
            a[i++] = 0;
            count0--;
        }
        while (count1 > 0) {
            a[i++] = 1;
            count1--;
        }
        while (count2 > 0) {
            a[i++] = 2;
            count2--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1, index = 0;
        while (index <= j) {
            if (nums[index] == 2)
                swap(nums, j--, index);
            else {
                if (nums[index] == 0)
                    swap(nums, i++, index);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 2, 1, 2, 0};
        sortColors(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
