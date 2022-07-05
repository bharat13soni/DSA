package com.practice.queue;

import java.util.*;

public class SlidingWindowMaximum {
    //Brute force method to find the maximum for each and every contiguous sub array of size k
    //O(n*k)
    public static void printKMax(int[] arr, int n, int k) {
        int j, max;
        for (int i = 0; i < n - k; i++) {
            max = arr[i];
            for (j = 1; j < k; j++) {
                if (arr[i + j] > max) {
                    max = arr[i + j];
                }
            }
            System.out.print(max + " ");
        }
    }

    //O(n * log k) O(k)
    public static List<Integer> printKMaxUsingPQ(int[] arr, int n, int k) {
        //Creating the max heap to get the max element always
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> res = new ArrayList<>();
        int i = 0;
        for (; i < k; i++) {
            queue.add(arr[i]);
        }

        //Adding the max elements from first k elements
        //res.add(queue.poll());
        res.add(queue.peek());
        //removing the first element of the array
        queue.remove(arr[0]);

        //iterating for the next elements
        for (; i < n; i++) {
            //adding the new element in the window
            queue.add(arr[i]);

            //finding & adding the max element in the current sliding window
            res.add(queue.peek());

            //finally removing the first element from the front end of queue
            queue.remove(arr[i - k + 1]);
        }
        return res;
    }

    //Time->O(n)  Space->O(k)
    public static void printKMaxUsingDeque(int[] arr, int n, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        //Process first k (or first window) elements of array
        int i;
        for (i = 0; i < k; i++) {
            //For every element previous smaller elements are useless
            //so remove from deque
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                //remove from rear
                deque.removeLast();
            }
            //Add new element at rear of queue
            deque.addLast(i);
        }

        //Process rest of the elements
        //i.e. from arr[k]...arr[n-1]
        for (; i < n; i++) {

            //the element at the front of the queue is the largest element
            //of previous window, so print it
            System.out.print(deque.peek() + " ");

            //Remove the elements which are out of this window
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.removeFirst();
            }

            //Remove all elements that are smaller than
            //the currently being added element
            //(remove useless elements)
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }

            //Add current element at rear
            deque.addLast(i);
        }
        //Print max element of last window
        System.out.print(deque.peek());
    }

}
