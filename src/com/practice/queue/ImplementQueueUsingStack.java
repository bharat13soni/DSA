package com.practice.queue;

import java.util.Stack;

/*
This approach affects the dequeue operation’s time complexity instead of the enqueue operation.

To enqueue an item into the queue, push the item into the first stack.
To dequeue an item from the queue, move elements from the first stack to the second stack if it is not empty,
and return the top item from the second stack.
 */
public class ImplementQueueUsingStack<T> {
    Stack<T> s1 = new Stack<>();
    Stack<T> s2 = new Stack<>();

    //O(1)
    void push(T data) {
        // push item into the first stack
        s1.push(data);
    }

    //O(N)
    public T pop() {
        // if both stacks are empty
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Underflow!!");
            System.exit(0);
        }
        //move elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        //keep pointer to top element to be returned as result
        T res = s2.pop();
        //move back elements from s2 to s1
        while ((!s2.isEmpty())) {
            s1.push(s2.pop());
        }
        return res;
    }

    //O(N)
    public T peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        T res = s2.peek();
        while ((!s2.isEmpty())) {
            s1.push(s2.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5};

        // insert the above keys into the stack
        ImplementQueueUsingStack<Integer> q = new ImplementQueueUsingStack<>();
        for (int key : keys) {
            q.push(key);
        }

        for (int i = 0; i < keys.length; i++) {
            System.out.println(q.pop());
        }
    }
}
