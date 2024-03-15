package com.practice.array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = new Intersection().intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Intersection of two arrays using Brute Force approach
     * Time Complexity: O(n*m)
     */
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

    /**
     * the intersect method finds the intersection of two integer arrays using the HashMap data structure.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        /*
      The method begins by creating a HashMap named map.
      This map is used to store the elements of nums1 as keys and their frequencies as values.
      The getOrDefault method is used to increment the value (frequency) if the key (element) already exists in the map, or add the key-value pair if it doesn't
        */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /*
         Next, the method creates an ArrayList named result. It then iterates over nums2.
         For each element in nums2, it checks if the element exists as a key in map and if its frequency is greater than 0. If both conditions are met,
         the element is added to the result list, and the frequency of the element in map is decremented.
         */
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                result.add(num);
                map.put(num, count - 1);
            }
        }

        /*
        Finally, the method creates a new integer array resultArray that is the same size as the result list.
        It then populates resultArray with the elements from the result list
         */
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    /**
     * Intersection of two sorted arrays using two pointers
     * Time Complexity: O(n+m)
     *
     * @param a
     * @param b
     * @return
     */

    public static int[] intersectionOfSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        //The method starts by initializing three integer variables i, j, and k to 0.
        // These variables are used to keep track of the current position in arrays a, b, and result respectively.
        int i = 0, j = 0, k = 0;
        //Next, an integer array result is created with a size equal to the minimum length of a and b. This array will store the intersecting elements.
        int[] result = new int[Math.min(n, m)];
        /*
         The method then enters a while loop that continues as long as i is less than the length of a and j is less than the length of b.
         Inside the loop, it checks if the current elements of a and b are equal.
         If they are, it checks if k is 0 or if the current element of `a` is not equal to the last element added to result.
         If either condition is met, the current element of `a` is added to result at the current index k, and k is incremented.
         Regardless of whether an element was added to result, i and j are both incremented.

         If the current elements of a and b are not equal, the method checks if the current element of `a` is less than the current element of b.
         If it is, `i` is incremented. Otherwise, `j` is incremented.
        */
        while (i < n && j < m) {
            if (a[i] == b[j]) {
                if (k == 0 || a[i] != result[k - 1]) {
                    result[k++] = a[i];
                }
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        /*
        Finally, the method creates a new array that contains only the elements in the result array up to the current index k.
        This is done using the Arrays.copyOf method, which creates a new array that is a copy of the specified range of the original array.
        This new array is returned as the result.
        */
        return Arrays.copyOf(result, k);
    }

    /**
     * If the elements of `nums2` are stored on disk and cannot be loaded into memory all at once,
     * you would need to modify the `intersect` method to process `nums2` in chunks that fit into memory.
     * <p>
     * Here's a high-level approach:
     * <p>
     * 1. Read a chunk of `nums2` from disk into memory.
     * 2. For each element in the chunk, check if it exists in the `map` and if its frequency is greater than 0.
     * If both conditions are met, add the element to the `result` list, and decrement the frequency of the element in `map`.
     * 3. Repeat steps 1-2 until all chunks of `nums2` have been processed.
     * 4. Convert the `result` list into an array and return it.
     * <p>
     * This approach assumes that `nums1` can fit into memory. If `nums1` also cannot fit into memory,
     * you would need to use an external sorting algorithm to sort both `nums1` and `nums2`, and then merge them to find the intersection.
     * <p>
     * Here's a simplified version of the `intersect` method that processes `nums2` in chunks:
     * <p>
     * This code assumes that `nums2` is stored in a text file named "nums2.txt", with the numbers separated by commas.
     * The `chunkSize` parameter determines how many elements of `nums2` are processed at a time.
     * The `BufferedReader` reads one line (chunk) of `nums2` at a time, and the `intersect` method processes each chunk as described above.
     */
    public int[] intersect(int[] nums1, int chunkSize) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("nums2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] chunk = line.split(",");
                for (String numStr : chunk) {
                    int num = Integer.parseInt(numStr);
                    int count = map.getOrDefault(num, 0);
                    if (count > 0) {
                        result.add(num);
                        map.put(num, count - 1);
                    }
                }
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
