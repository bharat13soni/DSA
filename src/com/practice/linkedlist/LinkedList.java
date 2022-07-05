package com.practice.linkedlist;

public class LinkedList {
    public static void main(String[] args) {

    }

    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        Node headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
    }

    /*
    Traverse linked list using two-pointers.
    Move one pointer by one and the other pointers by two.
    When the fast pointer reaches the end, the slow pointer will reach the middle of the linked list.
     */
    public static Node middle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*
    This method takes O(n) time and O(1) extra space.
    1) Get the middle of the linked list.
    2) Reverse the second half of the linked list.
    3) Check if the first half and second half are identical.
    4) Construct the original linked list by reversing the second half again and attaching it back to the first half
     */
    public static boolean isPalindrome(Node head) {
        if (head == null)
            return true;
        Node mid = middle(head);
        Node last = reverse(mid.next);
        Node curr = head;
        while (last != null) {
            if (last.data != curr.data) {
                return false;
            }
            last = last.next;
            curr = curr.next;
        }
        return true;
    }
}
