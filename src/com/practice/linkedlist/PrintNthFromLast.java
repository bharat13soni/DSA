package com.practice.linkedlist;

public class PrintNthFromLast {
    void printNthFromLast(Node head,int N)
    {
        Node main_ptr = head;
        Node ref_ptr = head;

        int count = 0;
        if (head != null) {
            while (count < N) {
                if (ref_ptr == null) {
                    System.out.println(
                            N + " is greater than the no "
                                    + " of nodes in the list");
                    return;
                }
                ref_ptr = ref_ptr.next;
                count++;
            }

            if (ref_ptr == null) {

                if (head != null)
                    System.out.println("Node no. " + N
                            + " from last is "
                            + head.data);
            }
            else {

                while (ref_ptr != null) {
                    main_ptr = main_ptr.next;
                    ref_ptr = ref_ptr.next;
                }
                System.out.println("Node no. " + N
                        + " from last is "
                        + main_ptr.data);
            }
        }
    }
}
