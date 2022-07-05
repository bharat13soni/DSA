package com.practice.stack;

public class StackImplementationUsingArray {
    int[] arr;
    int top;
    int capacity;

    public StackImplementationUsingArray(int capacity) {
        this.capacity = capacity;
        top = -1;
        arr = new int[capacity];
    }

    public void push(int data) {
        if (top == capacity - 1) {
            throw new IllegalArgumentException("Stack overflow");
        }
        top++;
        arr[top] = data;
    }

    public int pop() {
        if (top == -1) {
            throw new IllegalStateException("Underflow");
        }
        int res = arr[top];
        top--;
        return res;
    }

    public int peek() {
        if (top == -1) {
            throw new IllegalStateException("Underflow");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
