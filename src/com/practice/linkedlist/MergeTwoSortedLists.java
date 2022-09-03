package com.practice.linkedlist;

public class MergeTwoSortedLists {

    /**
     * (Using Dummy Nodes)
     * The strategy here uses a temporary dummy node as the start of the result list.
     * The pointer Tail always points to the last node in the result list, so appending new nodes is easy.
     * <p>
     * The dummy node gives the tail something to point to initially when the result list is empty.
     * This dummy node is efficient, since it is only temporary, and it is allocated in the stack.
     * The loop proceeds, removing one node from either ‘a’ or ‘b’, and adding it to the tail.
     * When We are done, the result is in dummy.next.
     */
    /* Takes two lists sorted in
    increasing order, and splices
    their nodes together to make
    one big sorted list which is
    returned. */
    public static Node sortedMerge(Node headA, Node headB) {

    /* a dummy first node to
       hang the result on */
        Node dummyNode = new Node(0);

    /* tail points to the
    last result node */
        Node tail = dummyNode;
        while (true) {

        /* if either list runs out,
        use the other list */
            if (headA == null) {
                tail.next = headB;
                break;
            }
            if (headB == null) {
                tail.next = headA;
                break;
            }

        /* Compare the data of the two
        lists whichever lists' data is
        smaller, append it into tail and
        advance the head to the next Node
        */
            if (headA.data <= headB.data) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }

            /* Advance the tail */
            tail = tail.next;
        }
        return dummyNode.next;
    }

    /**
     * Using Recursion
     * Merge is one of those nice recursive problems where the recursive solution code is much cleaner than the iterative code.
     * You probably would not want to use the recursive version for production code, however,
     * because it will use stack space which is proportional to the length of the lists.
     */
    public static Node sortedMergeRecursive(Node a, Node b) {
        // base cases
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        Node result;

        // pick either `a` or `b`, and recur
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMergeRecursive(a.next, b);
        } else {
            result = b;
            result.next = sortedMergeRecursive(a, b.next);
        }

        return result;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(4);
        l1.next = l2;
        l2.next = l3;

        Node l4 = new Node(1);
        Node l5 = new Node(3);
        Node l6 = new Node(4);
        l4.next = l5;
        l5.next = l6;
        Node node = sortedMerge(l1, l4);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
