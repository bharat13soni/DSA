package com.practice.queue;

public class QueueImplementationUsingArray {
    int[] arr;
    int capacity;
    int rear;

    public QueueImplementationUsingArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        rear = -1;
    }

    //O(N)
    public void enqueue(int data) {
        if (rear == capacity - 1) {
            throw new IllegalStateException("Overflow!!");
        }
        arr[++rear] = data;
    }

    //O(1)
    public int dequeue() {
        if (rear == -1) {
            throw new IllegalStateException("Underflow");
        }
        int result = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return result;
    }

    int getFront() {
        if (rear == -1) {
            throw new IllegalStateException("Underflow");
        }
        return arr[0];
    }
}
