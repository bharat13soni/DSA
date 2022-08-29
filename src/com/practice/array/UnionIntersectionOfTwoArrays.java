package com.practice.array;

import java.util.*;
import java.util.stream.IntStream;

public class UnionIntersectionOfTwoArrays {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {

            } else {
                return true;
            }
        }
        return false;
    }

    //BF
    public static int[] intersection(int[] a, int[] b) {
        int[] intersection = new int[a.length];
        int index = 0;
        for (int j : a) {
            for (int k : b) {
                if (j == k) {
                    intersection[index++] = j;
                }
            }
        }
        return intersection;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int index = 0;
        int[] intersect = new int[Math.max(nums1.length, nums2.length)];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.merge(i, 1, Integer::sum);
        }
        for (int j : nums2) {
            if (map.containsKey(j) && map.get(j) > 0) {
                intersect[index++] = j;
                map.put(j, map.get(j) - 1);
            }
        }

        /*// Copy the elements from starting till index
        // from original array to the other array
        System.arraycopy(arr, 0, anotherArray, 0, index);*/
        int finalIndex = index;
        return IntStream.range(0, intersect.length)
                .filter(i -> i < finalIndex)
                .map(i -> intersect[i])
                .toArray();
    }

    public static int[] intersectionUsingHashing(int[] a, int[] b) {
        int[] intersection = new int[Math.max(a.length, b.length)];
        int index = 0;
        Set<Integer> set = new HashSet<>();
        for (int j : a) {
            set.add(j);
        }
        for (int k : b) {
            if (set.contains(k)) {
                intersection[index++] = k;
            }
        }

        return IntStream.of(intersection)
                .filter(value -> value != 0)
                .toArray();
    }

    static void getUnion(int[] a, int n, int[] b, int m) {

        // Defining set container s
        HashSet<Integer> s = new HashSet<>();

        // Inserting array elements in s
        for (int i = 0; i < n; i++)
            s.add(a[i]);

        for (int i = 0; i < m; i++)
            s.add(b[i]);
        System.out.print("Number of elements after union operation: " + s.size() + "\n");
        System.out.print("The union set of both arrays is :" + "\n");

        System.out.print(s.toString() + " "); // s will contain only distinct
        // elements from array a and b
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
        System.out.println("The union set of both arrays is :");
        System.out.print(set);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersectionUsingHashing(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6})));
        System.out.println(Arrays.toString(intersectionUsingHashing(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); //{4,9} or {9,4}
        System.out.println(Arrays.toString(intersect(new int[]{8, 0, 3}, new int[]{0, 0}))); // {0}
        getUnion1(new int[]{8, 0, 3},3, new int[]{0, 0},2); // {0, 3, 8}
    }
}
