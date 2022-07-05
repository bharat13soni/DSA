package com.practice.array;

public class SortedLinkedListToBST {
    /*
    Method 1 (Simple)
    Following is a simple algorithm where we first find the middle node of the list and make it the root of the tree to be constructed.
     1) Get the Middle of the linked list and make it root.
    2) Recursively do same for the left half and right half.
        a) Get the middle of the left half and make it left child of the root
        created in step 1.
        b) Get the middle of right half and make it the right child of the
        root created in step 1.
    Time complexity: O(nLogn) where n is the number of nodes in Linked List.
    */
}
