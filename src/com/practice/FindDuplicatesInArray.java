package com.practice;

public class FindDuplicatesInArray {

    public static void main(String[] args) {
        int[] arr = {0, 4, 3, 2, 7, 8, 2, 3, 1};
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % arr.length] = arr[arr[i] % arr.length] + arr.length;
        }
        System.out.print("Array after modification :");
        for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
            int item = arr[i];
            System.out.print(item + ", ");
        }
        System.out.println();
        System.out.print("Duplicates : ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr.length * 2) {
                System.out.print(i + " ");
            }
        }
    }
}
