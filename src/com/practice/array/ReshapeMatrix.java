package com.practice.array;

import java.util.LinkedList;
import java.util.Queue;

public class ReshapeMatrix {
    /*
    https://leetcode.com/articles/reshape-the-matrix/
Do you know how a 2-D array is stored in the main memory(which is 1-D in nature)?
It is internally represented as a 1-D array only.
The element nums[i][j] of nums array is represented in the form of a one dimensional array
by using the index in the form: nums[m*i+j], where m is the number of columns in the given matrix.
Looking at the same in the reverse order, while putting the elements in the elements in the resultant matrix,
we can make use of a count variable which gets incremented for every element traversed as
if we are putting the elements in a 1-D resultant array. But, to convert the count back into 2-D matrix indices
with a column count of c, we can obtain the indices as res[count/c][count%c]
where count/c is the row number and count%c is the column number.
Thus, we can save the extra checking required at each step.
     */
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if ((m * n) == (r * c)) {
            int[][] res = new int[r][c];
            int k = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++, k++) {
                    res[i][j] = mat[k / m][k % m];
                }
            }
            return res;
        }
        return mat;
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;

        int[][] result = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[row][col] = nums[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4, 5, 6}};
        int A = 2;
        int B = 3;
        int[][] reshape = matrixReshape(mat, A, B);
        for (int i = 0; i < reshape.length; i++) {
            for (int j = 0; j < reshape[0].length; j++) {
                System.out.print(reshape[i][j] + " ");
            }
            System.out.println();
        }
    }
}
