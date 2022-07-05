package com.practice.linkedlist;

public class CloneLinkedListWithRandomPointers {

    // This function clones a given
    // linked list in O(1) space
    public static Node clone(Node head) {
        Node curr = head, temp = null;

        // insert additional node after
        // every node of original list
        while (curr != null) {
            temp = curr.next;

            // Inserting node
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;

        // adjust the random pointers of the
        // newly added nodes
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = (curr.random != null) ? curr.random.next : null;

            // move to the next newly added node by
            // skipping an original node
            curr = curr.next.next;
        }

        Node original = head, copy = head.next;

        // save the head of copied linked list
        temp = copy;

        // now separate the original list and copied list
        while (original != null) {
            original.next = original.next.next;

            copy.next = (copy.next != null) ? copy.next.next : null;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }
}
