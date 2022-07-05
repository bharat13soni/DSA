package com.practice.queue;

public class CircularArrayQueue {
    int[] arr;
    int n;
    int front = -1, rear = -1;

    public CircularArrayQueue(int n) {
        this.n = n;
        arr = new int[n];
    }

    void enqueue(int data) {
        if ((rear + 1) % n == front) {
            throw new RuntimeException("Overflow!!");
        }
        if (front == -1)
            front = 0;
        rear = (rear + 1) % n;
        arr[rear] = data;
    }

    public int dequeue() {
        if (front == -1) {
            throw new IllegalStateException("Underflow!!");
        }
        int result = arr[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % n;
        }
        return result;
    }
}
