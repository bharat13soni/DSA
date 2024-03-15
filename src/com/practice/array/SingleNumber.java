package com.practice.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    /**
     * In this approach, you can compare each number with the rest of the numbers in the array.
     * In case you find a duplicate proceed to the next number and in case you don’t find a duplicate,
     * you return the current number as a Single.
     */
    public static int singleNumber1(int[] numbers) {
        // ----------------------------------------------
        // Brute Force -- O(n**2),  Space Complexity O(1)
        // ----------------------------------------------
        int len = numbers.length;
        boolean isTwice = false;
        for (int i = 0; i < len; i++) {
            isTwice = false;
            for (int j = 0; j < len; j++) {
                if (i != j && (numbers[i] == numbers[j])) {
                    isTwice = true;
                    break;
                }
            }
            if (!isTwice) {
                return numbers[i];
            }
        }
        return numbers[len - 1];
    }

    /*
    To improve on the brute force approach you can apply sorting first to avoid going back and forth
    in the array while comparing each number with the rest of the numbers in the array.
    After sorting, you would just need a single pass on the array of numbers to find a single number.
    Sorting can be done in O(NlogN) time, this approach is faster than the above one.
    Also, we don’t need additional space so the space complexity would be O(1).
     */
    public int singleNumber2(int[] numbers) {
        // -----------------------------------------------------------
        // Sorting -- Time Complexity O(nlogn), Space Complexity O(1)
        // -----------------------------------------------------------
        Arrays.sort(numbers);
        int len = numbers.length;
        int i = 0;
        while (i < len - 2) {
            if (numbers[i] == numbers[i + 1]) {
                i = i + 2;
            } else {
                return numbers[i];
            }
        }
        return numbers[len - 1];
    }

    /*
    In order to reduce the time complexity further, you can instead use a HashMap.
    This way you don’t need to sort the array. This approach improves a space/time tradeoff to improved performance.
    This has a time complexity of O(N) whereas its space complexity is also O(N).
     */
    public int singleNumber3(int[] numbers) {
        // -------------------------------------------------------------
        // Using Hash Map -- Time Complexity O(n), Space Complexity O(n)
        // -------------------------------------------------------------
        Map<Integer, Boolean> map = new HashMap<>();

        for (int number : numbers) {
            map.put(number, !map.getOrDefault(number, false));
        }

        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (Boolean.TRUE.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return Integer.MIN_VALUE;
    }

    /*
    The most optimal solution does not use any additional space and has linear time complexity.
    The idea is to start with 0 and apply use logical exclusive OR (XOR) operator on the entire array.
    The final result would be the desired single number to be returned.

    This operator is a binary operator, denoted by ‘^.’
    It returns bit by bit XOR of input values, i.e., if corresponding bits are different, it gives 1, else it shows 0.
     */
    public static int singleNumber(int[] numbers) {
        // Using XOR Bit Manipulation --
        //         Time Complexity: O(n), Space Complexity: O(1)
        // -----------------------------------------------------
        int result = 0;
        for (int number : numbers) {
            result ^= number; // Logical XOR operator
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 1, 2, 3, 3}));
    }
}
