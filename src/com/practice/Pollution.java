package com.practice;

import java.util.*;

public class Pollution {
    public static int pollution(int[] A) {
        A = Arrays.stream(A).filter(num -> num != 0).toArray();
        int filters = 0;
        int half = 0, currSum = 0, temp = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : A) {
            pq.add(i);
            half += i;
        }

        currSum = half;
        half = half / 2;

        while (currSum > half) {
            temp = pq.poll();
            currSum -= temp / 2;
            pq.add(temp / 2);
            filters++;
        }

        return filters;
    }


    public static void main(final String[] args)
    {
//        System.out.println(pollution(new int[]{5,19,8,1}));
        System.out.println(pollution(new int[]{3, 0, 5}));
    }
}
