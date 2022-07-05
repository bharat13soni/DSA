package com.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesesMatchingProblem {
    public static void main(String[] args) {
        System.out.println(isParenthesesMatching("[{((()))}]"));
    }

    public static boolean isParenthesesMatching(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (isOpening(curr)) {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (!isMatching(stack.peek(), curr)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatching(char a, char b) {
        return (a == '(' && b == ')')
                || (a == '{' && b == '}')
                || (a == '[' && b == ']');
    }

    private static boolean isOpening(char curr) {
        return curr == '[' || curr == '{' || curr == '(';
    }
}
