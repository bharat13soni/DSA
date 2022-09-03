package com.practice.linkedlist;

public class RemoveElements {
    /*
    We need to first check for all occurrences at the head node and change the head node appropriately.
    Then we need to check for all occurrences inside a loop and delete them one by one.
     */
    public static Node removeElements(Node head, int val) {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key
        // or multiple occurrences of key
        while (temp != null && temp.data == val) {
            head = temp.next; // Changed head
            temp = head; // Change Temp
        }

        // Delete occurrences other than head
        while (temp != null) {
            // Search for the key to be deleted,
            // keep track of the previous node
            // as we need to change 'prev->next'
            while (temp != null && temp.data != val) {
                prev = temp;
                temp = temp.next;
            }

            // If key was not present in linked list
            if (temp == null)
                return head;

            // Unlink the node from linked list -> remove temp node
            prev.next = temp.next;

            // Update Temp for next iteration of outer loop
            temp = prev.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(1);
        Node l3 = new Node(1);
        l1.next = l2;
        l2.next = l3;
        Node node = removeElements(l1, 1);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

}
