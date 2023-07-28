package com.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hospital {

    public static int solve(int[][] A) {
        // each row => one hospital schedule
        // M column => days
        // A[K][L] => id of doc working at K hospital on L day
        int op = 0;
        Map<Integer, Set<Integer>> docToHosp = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                int key = A[i][j];
                Set<Integer> set = docToHosp.get(key);
                if (set == null) {
                    Set<Integer> newSet = new HashSet<>();
                    newSet.add(i);
                    docToHosp.put(key, newSet);
                } else {
                    set.add(i);
                    docToHosp.put(key, set);
                }
            }
        }

        for (Map.Entry<Integer, Set<Integer>> entry : docToHosp.entrySet()) {
            if (entry.getValue().size() > 1) {
                op++;
            }
        }

        // number of doctors working at more than one hospital!
        return op;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 2}, {3, 1, 4}};
//        int[][] A = {{1,1,5,2,3}, {4,5,6,4,3}, {9,4,4,1,5}};
//        int[][] A = {{4, 3}, {5, 5}, {6, 2}};
        System.out.println(solve(A));
    }
}
