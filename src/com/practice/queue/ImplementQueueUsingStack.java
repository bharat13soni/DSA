package com.practice.queue;

import java.util.Stack;

public class ImplementQueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    //O(1)
    void push(int data) {
        s1.push(data);
    }

    //O(N)
    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int res = s2.pop();
        while ((!s2.isEmpty())) {
            s1.push(s2.pop());
        }
        return res;
    }

    //O(N)
    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int res = s2.peek();
        while ((!s2.isEmpty())) {
            s1.push(s2.pop());
        }
        return res;
    }
}
