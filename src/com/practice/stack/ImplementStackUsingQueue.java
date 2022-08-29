package com.practice.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue<T> {
    Queue<T> q1 = new LinkedList<>();
    Queue<T> q2 = new LinkedList<>();

    /*
    The idea is to implement the queue’s enqueue operation such that the last entered item always ends up at the queue’s front.
    To achieve this, we need an additional queue.

    1.To push an item into the stack, first move all elements from the first queue to the second queue,
    then enqueue the new item into the first queue, and finally move all elements back to the first queue.
    This ensures that the new item lies in front of the queue and hence would be the first one to be removed.

    2.To pop an item from the stack, return the front item from the first queue.
     */

    public void push(T data) {
        // Move all elements from the first queue to the second queue
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // Push the given item into the first queue
        q1.offer(data);
        // Move all elements back to the first queue from the second queue
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    public T poll() {
        // if the first queue is empty
        if (q1.isEmpty()) {
            System.out.println("Underflow!!");
            System.exit(0);
        }
        return q1.poll();
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5};

        // insert the above keys into the stack
        ImplementStackUsingQueue<Integer> s = new ImplementStackUsingQueue<>();
        for (int key : keys) {
            s.push(key);
        }

        for (int i = 0; i < keys.length; i++) {
            System.out.println(s.poll());
        }
    }
}
