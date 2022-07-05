package com.practice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenMultiLevelLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        six.next = seven;
        head.down = six;
        Node node = flattenUsingQueue(head);
    }

    public static Node flattenUsingQueue(Node head) {
        Queue<Node> queue = new LinkedList<>();
        Node current = head;

        while (current != null) {
            if (current.next == null) {
                current.next = queue.poll();
            }
            if (current.down != null) {
                queue.offer(current.down);
            }
            System.out.println(current.data);
            current = current.next;
        }
        return head;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node tmp = null;

        //Find last node of first level linked list
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        /*
        One by one traverse through all nodes of first level
        linked list till we reach the tail node
         */
        Node curr = head;
        while (curr != tail) {

            //if current node has a down node
            if (curr.down != null) {
                tail.next = curr.down;

                //and update the tail to new last node
                tmp = curr.down;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tail = tmp;
            }
            //change curr node
            System.out.println(curr.data);
            curr = curr.next;
        }
        return head;
    }

    static class Node {
        public int data;
        public Node next;
        public Node down;

        Node(int data) {
            this.data = data;
        }
    }
}

