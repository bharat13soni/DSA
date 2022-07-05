package com.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        previousSmallerElement(new int[]{4, 10, 5, 18, 3, 12, 7});
        previousGreaterElement(new int[]{4, 10, 5, 18, 3, 12, 7});
    }

    public static void previousSmallerElement(int[] arr) {
//        Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                System.out.println(-1);
            else
                System.out.println(stack.peek());

            stack.push(arr[i]);
        }
    }

    public static void previousGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                System.out.println(-1);
            else
                System.out.println(stack.peek());

            stack.push(arr[i]);
        }
    }
}
