package com.practice.array;

/**
 * The `FindDuplicatesInArray` class in Java is designed to find duplicate elements in an array.
 *
 * Here's a step-by-step breakdown of what the code does:
 *
 * 1. It initializes an array `arr` with some integer values.
 * 2. It then modifies the array such that for each element at index `i`,
 * it increments the value at index `arr[i] % arr.length` by `arr.length`.
 * 3. It prints the array after modification.
 * 4. Finally, it traverses the modified array. If an element at index `i` is greater than or equal to `arr.length * 2`,
 * it means the element `i` is a duplicate in the original array. It prints out these duplicate elements.
 *
 * This method works on the principle that array elements are in the range from 0 to `n-1` where `n` is the size of the array.
 * It uses the array elements as an index and increments the value at that index by the size of the array.
 * In the end, if any value in the array is more than twice the size of the array, it means the index is a duplicate.
 */

public class FindDuplicatesInArray {


    public static void main(String[] args) {
     int[] arr = {0, 4, 3, 2, 7, 8, 2, 3, 1};
        modifyArrayForDuplicates(arr);
        printArray(arr);
        printDuplicates(arr);
    }

    private static void modifyArrayForDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % arr.length] += arr.length;
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("Array after modification :");
        for (int item : arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    private static void printDuplicates(int[] arr) {
        System.out.print("Duplicates : ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr.length * 2) {
                System.out.print(i + " ");
            }
        }
    }
}