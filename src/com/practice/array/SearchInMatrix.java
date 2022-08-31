package com.practice.array;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class SearchInMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        OptionalInt optionalInt = Arrays.stream(matrix).flatMapToInt(IntStream::of).filter(value -> value == target).findFirst();
        return optionalInt.isPresent();
    }

    /**
     * Efficient approach: The simple idea is to remove a row or column in each comparison until an element is found.
     * Start searching from the top-right corner of the matrix.
     * There are three possible cases.
     * <p>
     * 1.The given number is greater than the current number:
     * This will ensure that all the elements in the current row are smaller than the given number
     * as the pointer is already at the right-most elements and the row is sorted.
     * Thus, the entire row gets eliminated and continues the search for the next row. Here, elimination means
     * that a row needs not be searched.
     * <p>
     * 2.The given number is smaller than the current number:
     * This will ensure that all the elements in the current column are greater than the given number.
     * Thus, the entire column gets eliminated and continues the search for the previous column,
     * i.e. the column on the immediate left.
     * <p>
     * 3.The given number is equal to the current number: This will end the search.
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        // set indexes for top right
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("3 present in [[1,3,5,7],[10,11,16,20],[23,30,34,60]] ->" + searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println("1 present in [[1]] ->" + searchMatrix(new int[][]{{1}}, 1));
        System.out.println("1 present in [[1]] ->" + searchMatrix1(new int[][]{{1}}, 1));
    }
}
