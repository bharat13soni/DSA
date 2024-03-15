package com.practice.array;

import java.util.Arrays;

/**
 * We need to modify the array in-place and the size of the final array would potentially be smaller than the size of the input array.
 * So, we ought to use a two-pointer approach here.
 * One, that would keep track of the current element in the original array and another one for just the unique elements.
 *
 * Essentially, once an element is encountered, you simply need to bypass its duplicates and move on to the next unique element.
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
//        int[] arr = {1, 1, 2};
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int uniqueSize = new RemoveDuplicates().removeDuplicates(arr);
        System.out.println(uniqueSize);
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOf(arr, uniqueSize)));
    }

    /**
     * The `removeDuplicates` method in Java is designed to remove duplicate elements from an array.
     * <p>
     * Here's a step-by-step breakdown of what the code does:
     * <p>
     * 1. It initializes an array `nums` with some integer values.
     * 2. It initializes a variable `j` to 0.
     * 3. It then traverses the array from index 1 to the end.
     * 4. If the element at index `i` is not equal to the element at index `j`,
     * it increments `j` by 1 and sets the element at index `j` to the element at index `i`.
     * 5. It returns `j + 1` which is the size of the array after removing duplicates.
     * <p>
     * This method works by maintaining two pointers `i` and `j`. The pointer `i` traverses the array and the pointer `j` points to the last unique element in the array.
     * If the element at index `i` is not equal to the element at index `j`, it increments `j` by 1 and sets the element at index `j` to the element at index `i`.
     * In the end, it returns `j + 1` which is the size of the array after removing duplicates.
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        System.out.println("Array after removing duplicates: " + Arrays.toString(nums));
        return j + 1;
    }
}
