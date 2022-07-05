package com.practice.queue;

import com.practice.linkedlist.Node;

public class QueueImplementationUsingLinkedList {
    Node front, rear;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Underflow");
        }
        int result = front.data;
        front = front.next;
        return result;
    }
}
