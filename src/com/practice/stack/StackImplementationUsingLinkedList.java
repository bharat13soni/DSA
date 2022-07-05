package com.practice.stack;

import com.practice.linkedlist.Node;

public class StackImplementationUsingLinkedList {
    Node head;
    int size;

    public StackImplementationUsingLinkedList() {
        this.head = null;
        size = 0;
    }

    public void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        size++;
        head = temp;
    }

    public int pop() {
        if (head == null) {
            throw new IllegalStateException("Underflow!!");
        }
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }

    public int peek() {
        if (head == null) {
            throw new IllegalStateException("Underflow!!");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
