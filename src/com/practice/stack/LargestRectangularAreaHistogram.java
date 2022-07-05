package com.practice.stack;

import java.util.Stack;

public class LargestRectangularAreaHistogram {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }

    public static int largestAreaSubMatrixWithAll1(int[][] arr) {
        int[] currRow = arr[0];
        int maxAns = maxArea(currRow);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    currRow[j] += 1;
                } else {
                    currRow[j] = 0;
                }
            }
            int currAns = maxArea(currRow);
            maxAns = Math.max(maxAns, currAns);
        }
        return maxAns;
    }

    public static int maxArea(int[] arr) {
        int maxAns = 0;
        int[] previousSmaller = previousSmaller(arr);
        int[] nextSmaller = nextSmaller(arr);
        for (int i = 0; i < arr.length; i++) {
            int curr = (nextSmaller[i] - previousSmaller[i] - 1) * arr[i];
            maxAns = Math.max(maxAns, curr);
        }
        return maxAns;
    }

    private static int[] nextSmaller(int[] arr) {
        int[] ns = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ns[i] = arr.length + 1;
            } else {
                ns[i] = stack.peek();
            }

            stack.push(i);

        }
        return ns;
    }

    private static int[] previousSmaller(int[] arr) {
        int[] ps = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ps[i] = -1;
            } else {
                ps[i] = stack.peek();
            }

            stack.push(i);

        }
        return ps;
    }
}
