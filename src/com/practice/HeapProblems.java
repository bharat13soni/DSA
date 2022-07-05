package com.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapProblems {
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 6};
        int size = arr.length;
        System.out.println("Total cost for connecting"
                + " ropes is " + minCost(arr, size));

        // stream of integers
        int[] arr1 = new int[]{5, 15, 10, 20, 3};
        printMedian(arr1);
    }

    static int minCost(int arr[], int n) {
        // Create a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding items to the pQueue
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        // Initialize result
        int res = 0;

        // While size of priority queue
        // is more than 1
        while (pq.size() > 1) {
            // Extract shortest two ropes from pq
            int first = pq.poll();
            int second = pq.poll();

            // Connect the ropes: update result
            // and insert the new rope to pq
            res += first + second;
            pq.add(first + second);
        }

        return res;
    }

    /*
    Median in a stream of integers (running integers)
     */
    public static void printMedian(int[] a) {

        double med = a[0];

        // max heap to store the smaller half elements
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        // min-heap to store the greater half elements
        PriorityQueue<Integer> greater = new PriorityQueue<>();

        smaller.add(a[0]);
        System.out.println(med);

        // reading elements of stream one by one
        /* At any time we try to make heaps balanced and
            their sizes differ by at-most 1. If heaps are
            balanced,then we declare median as average of
            min_heap_right.top() and max_heap_left.top()
            If heaps are unbalanced,then median is defined
            as the top element of heap of larger size */
        for (int i = 1; i < a.length; i++) {

            int x = a[i];

            // case1(left side heap has more elements)
            if (smaller.size() > greater.size()) {
                if (x < med) {
                    greater.add(smaller.remove());
                    smaller.add(x);
                } else
                    greater.add(x);
                med = (double) (smaller.peek() + greater.peek()) / 2;
            }

            // case2(both heaps are balanced)
            else if (smaller.size() == greater.size()) {
                if (x < med) {
                    smaller.add(x);
                    med = (double) smaller.peek();
                } else {
                    greater.add(x);
                    med = (double) greater.peek();
                }
            }

            // case3(right side heap has more elements)
            else {
                if (x > med) {
                    smaller.add(greater.remove());
                    greater.add(x);
                } else
                    smaller.add(x);
                med = (double) (smaller.peek() + greater.peek()) / 2;

            }
            System.out.println(med);
        }
    }
}
