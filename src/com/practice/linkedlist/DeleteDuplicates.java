package com.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicates {

    public static Node deleteDuplicates(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr = head;
        while (curr.next != null) {
            if (curr.data == curr.next.data) {
                // Pointing the node next of next node of current to remove the next of current
                // (which is equal to current.val)
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static Node deleteDuplicatesUsingHashing(Node head) {
        Set<Integer> set = new HashSet<>();
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (!set.add(curr.data)) {
                Node temp = curr.next;
                prev.next = temp;
                curr = temp;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(1);
        Node l3 = new Node(2);
        Node l4 = new Node(3);
        Node l5 = new Node(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        Node node = deleteDuplicates(l1);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
