package com.practice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Union {

    static void getUnion(int[] a, int n, int[] b, int m) {

        // Defining set container s
        HashSet<Integer> s = new HashSet<>();

        // Inserting array elements in s
        for (int i = 0; i < n; i++) {
            s.add(a[i]);
        }

        for (int i = 0; i < m; i++) {
            s.add(b[i]);
        }
        System.out.print("Number of elements after union operation: " + s.size() + "\n");
        System.out.print("The union set of both arrays is :" + s);// s will contain only distinct elements from array a and b
    }

    static void getUnion1(int[] a, int n, int[] b, int m) {
        int min = Math.min(n, m);
        Set<Integer> set = new HashSet<>();

        // add elements from both the arrays for
        // index from 0 to min(n, m)-1
        for (int i = 0; i < min; i++) {
            set.add(a[i]);
            set.add(b[i]);
        }

        // add remaining elements to the set from the other
        // array (having greater length)
        // note that only one of the loops will execute
        if (n > m) {
            for (int i = m; i < n; i++) {
                set.add(a[i]);
            }
        } else if (n < m) {
            for (int i = n; i < m; i++) {
                set.add(b[i]);
            }
        }
        System.out.println("Number of elements after union operation: " + set.size());
        System.out.println("The union set of both arrays is :" + set);
    }

    public static void main(String[] args) {
        getUnion1(new int[]{8, 0, 3}, 3, new int[]{0, 0}, 2); // {0, 3, 8}
        int[] a = {1, 2, 5, 6, 2, 3, 5, 7, 3};
        int[] b = {2, 4, 5, 6, 8, 9, 4, 6, 5, 4};

        getUnion1(a, 9, b, 10);
    }
}
