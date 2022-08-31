package com.practice.linkedlist;

import java.util.Stack;

public class Palindrome {
    /*
    METHOD 1 (Use a Stack)

    A simple solution is to use a stack of list nodes. This mainly involves three steps.
    1.Traverse the given list from head to tail and push every visited node to stack.
    2.Traverse the list again. For every visited node, pop a node from the stack and compare data of popped node with the currently visited node.
    3.If any node data not matched with stack value, then return false. After loop completion return true.

    Time complexity: O(n)
    Auxiliary Space: O(n) since we are using an auxiliary stack
     */
    static boolean isPalindrome(Node head) {
        Node slow = head;
        Stack<Integer> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        while (head != null) {
            if (head.data != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
    METHOD 2 (By reversing the list)
    This method takes O(n) time and O(1) extra space.
    1) Get the middle of the linked list.
    2) Reverse the second half of the linked list.
    3) Check if the first half and second half are identical.
    4) Construct the original linked list by reversing the second half again and attaching it back to the first half
     reference to {@link LinkedList#isPalindrome}
     */

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        System.out.println("isPalindrome :" + isPalindrome(one));
    }
}
