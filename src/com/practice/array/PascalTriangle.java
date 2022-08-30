package com.practice.array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
1 6 15 20 15 6 1
 */
public class PascalTriangle {
    public static void printPascal(int n) {
        // An auxiliary array to store generated pascal triangle values
        int[][] arr = new int[n][n];

        // Iterate through every line and print integer(s) in it
        for (int line = 0; line < n; line++) {
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++) {
                // First and last values in every row are 1
                if (line == i || i == 0)
                    arr[line][i] = 1;
                else // Other values are sum of values just above and left of above
                    arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
                System.out.print(arr[line][i]);
            }
            System.out.println("");
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(Collections.singletonList(1));
        for (int line = 1; line < numRows; line++) {
            List<Integer> l = new LinkedList<>();
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++) {
                // First and last values in every row are 1
                if (line == i || i == 0)
                    l.add(i, 1);
                else // Other values are sum of values just above and left of above
                    l.add(i, list.get(line - 1).get(i - 1) + list.get(line - 1).get(i));
            }
            list.add(line, l);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
