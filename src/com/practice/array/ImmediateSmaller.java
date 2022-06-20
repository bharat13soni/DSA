package com.practice.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ImmediateSmaller {

    public static void main(String[] args) {
        int[] arr = {5, 6, 2, 3, 1, 7};
        immediateSmaller(arr, 6);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        printNSE(new int[]{11, 2, 21, 3}, 4);
    }

    static void immediateSmaller(int arr[], int n) {
        for (int j = 0; j < n; j++) {
            if (j == n - 1) {
                arr[j] = -1;
            } else if (arr[j + 1] < arr[j]) {
                arr[j] = arr[j + 1];
            } else {
                arr[j] = -1;
            }
        }
    }

    /* prints element and NSE pair for all
    elements of arr[] of size n */
    public static void printNSE(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        /* push the first element to stack */
        stack.push(arr[0]);

        // iterate for rest of the elements
        for (int i = 1; i < n; i++) {
            if (stack.empty()) {
                stack.push(arr[i]);
                continue;
            }

            /* if stack is not empty, then
            pop an element from stack.
            If the popped element is greater
            than next, then
            a) print the pair
            b) keep popping while elements are
            greater and stack is not empty */

            while (!stack.empty()
                    && stack.peek() > arr[i]) {
                map.put(stack.peek(), arr[i]);
                stack.pop();
            }

            /* push next to stack so that we can find
            next smaller for it */
            stack.push(arr[i]);
        }

        /* After iterating over the loop, the remaining
        elements in stack do not have the next smaller
        element, so print -1 for them */
        while (!stack.empty()) {
            map.put(stack.peek(), -1);
            stack.pop();
        }
        System.out.println("Printing NSE : ");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ---> " + map.get(arr[i]));
        }
    }
}
