package com.practice.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Input:
 * arr[] = {1, 2, 3, 4, 5, 6, 7}, d = 2
 * Output: 3 4 5 6 7 1 2
 * <p>
 * Input: arr[] = {3, 4, 5, 6, 7, 1, 2}, d=2
 * Output: 5 6 7 1 2 3 4
 */
public class ArrayLeftRotation {

    /**
     * Approach 1 (Using temp array): This problem can be solved using the below idea:
     * <p>
     * After rotating d positions to the left, the first d elements become the last d elements of the array
     * <p>
     * First store the elements from index d to N-1 into the temp array.
     * Then store the first d elements of the original array into the temp array.
     * Copy back the elements of the temp array into the original array
     * <p>
     * Suppose the give array is arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2.
     * <p>
     * First Step:
     * => Store the elements from 2nd index to the last.
     * => temp[] = [3, 4, 5, 6, 7]
     * <p>
     * Second Step:
     * => Now store the first 2 elements into the temp[] array.
     * => temp[] = [3, 4, 5, 6, 7, 1, 2]
     * <p>
     * Third Steps:
     * => Copy the elements of the temp[] array into the original array.
     * => arr[] = temp[] So arr[] = [3, 4, 5, 6, 7, 1, 2]
     * <p>
     * Time complexity: O(N)
     * Auxiliary Space: O(N)
     */

    public static void Rotate(int[] arr, int d, int n) {
        // Storing rotated version of array
        int[] temp = new int[n];

        // Keeping track of the current index
        // of temp[]
        int k = 0;

        // Storing the n - d elements of
        // array arr[] to the front of temp[]
        for (int i = d; i < n; i++) {
            temp[k] = arr[i];
            k++;
        }

        // Storing the first d elements of array arr[]
        //  into temp
        for (int i = 0; i < d; i++) {
            temp[k] = arr[i];
            k++;
        }

        // Copying the elements of temp[] in arr[]
        // to get the final rotated array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * Approach 2 (Rotate one by one): This problem can be solved using the below idea:
     * <p>
     * At each iteration, shift the elements by one position to the left circularly (i.e., first element becomes the last).
     * Perform this operation d times to rotate the elements to the left by d position.
     * <p>
     * Let us take arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2.
     * <p>
     * First Step:
     * => Rotate to left by one position.
     * => arr[] = {2, 3, 4, 5, 6, 7, 1}
     * <p>
     * Second Step:
     * => Rotate again to left by one position
     * => arr[] = {3, 4, 5, 6, 7, 1, 2}
     * <p>
     * Rotation is done by 2 times.
     * So the array becomes arr[] = {3, 4, 5, 6, 7, 1, 2}
     * <p>
     * Follow the steps below to solve the given problem.
     * <p>
     * Rotate the array to left by one position. For that do the following:
     * Store the first element of the array in a temporary variable.
     * Shift the rest of the elements in the original array by one place.
     * Update the last index of the array with the temporary variable.
     * Repeat the above steps for the number of left rotations required.
     * Time Complexity: O(N * d)
     * Auxiliary Space: O(1)
     */

    public static void rotate(int[] arr, int d, int n) {
        int p = 1;
        while (p <= d) {
            int last = arr[0];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[n - 1] = last;
            p++;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Deque is also known as double ended queue. Module also provides different in-built methods. One of them is “rotate”.
     * Time complexity: The time complexity of the code is O(d*n), where d is the number of rotations and n is the size of the deque.
     * The auxiliary space is O(n), where n is the size of the deque.
     */
    public static void rotateUsingDeque(int[] inp, int d) {
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i : inp) {
            deq.add(i);
        }

        for (int i = 0; i < d; i++) {
            int temp = deq.remove();
            deq.addLast(temp);
        }

        System.out.println(deq);
    }

    public static void main(String[] args) {
        int[] inp = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        rotateUsingDeque(inp, d);
    }

}
