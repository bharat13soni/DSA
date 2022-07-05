package com.practice.linkedlist;

public class DetectCycle {
    /*
        Floyd’s Cycle-Finding Algorithm
     */
    public static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public static Node detectFirstNode(Node head) {
        Node meet = detectCycle(head);
        Node prev=meet;
        if (meet == null)
            return null;
        Node start = head;
        while (start != meet) {
            start = start.next;
            meet = meet.next;
        }
        return start;
    }

    void detectAndRemoveLoop(Node head)
    {

        // If list is empty or has only one node
        // without loop
        if (head == null || head.next == null)
            return;

        Node slow = head, fast = head;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        /* If loop exists */
        if (slow == fast) {
            slow = head;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                /* since fast->next is the looping point */
                fast.next = null; /* remove loop */
            }
            /* This case is added if fast and slow pointer meet at first position. */
            else {
                while(fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }
}
