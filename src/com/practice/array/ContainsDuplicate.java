package com.practice.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /**
     * The `containsDuplicate` method is designed to find if there are any duplicate elements in the array.
     * Here's how it works:
     * 1. It initializes a boolean array `visited` of size `nums.length` with all elements set to `false`.
     * 2. It then iterates through the array `nums` and checks if the element at index `i` is already visited.
     * If it is, it returns `true` as it means the element is a duplicate.
     * If it isn't, it sets the element at index `i` in the `visited` array to `true`.
     * 3. If no duplicate is found, it returns `false`.
     */
    public static boolean containsDuplicate(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for (int num : nums) {
            if (visited[num]) {
                return true;
            }
            visited[num] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicateUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * The `containsDuplicateUsingXor` method is designed to check if there are any duplicate elements in the array using the XOR operation.
     * However, the current implementation is incorrect as it doesn't correctly identify duplicates.
     * <p>
     * The XOR operation has the following properties:
     * 1. `A XOR A = 0`
     * 2. `A XOR 0 = A`
     * 3. `A XOR B XOR A = A XOR A XOR B = 0 XOR B = B`
     * <p>
     * From these properties, you might think that if there are duplicates in the array, the result of XORing all elements should be 0.
     * However, this is not the case because the order of elements in the array is not guaranteed.
     * For example, if the array is [2, 1, 2, 1, 3], the result of XORing all elements is 3, not 0.
     * <p>
     * Therefore, the `containsDuplicateUsingXor` method in its current form cannot correctly identify duplicates in the array.
     * A more suitable approach would be to use a HashSet as shown in the `containsDuplicateUsingSet` method in code.
     *
     * @param nums
     * @return
     */

    public static boolean containsDuplicateUsingXor(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor != 0;
    }

    /**
     * To solve this problem, you can use the XOR operation. The XOR operation has the following properties:
     * <p>
     * 1. `A XOR A = 0`
     * 2. `A XOR 0 = A`
     * So, if we XOR all the elements in the array, we will be left with the element that appears only once.
     * This is because the XOR of any number with itself is 0, and the XOR of any number with 0 is the number itself.
     * Therefore, the XOR of all the elements in the array will cancel out the elements that appear twice, leaving only the element that appears once.
     * <p>
     * The `singleNumber` method is designed to find the single number in the array that appears only once.
     * Here's how it works:
     * 1. It initializes `result` to 0.
     * 2. It then iterates through the array `nums` and XORs each element with `result`.
     * 3. At the end of the loop, `result` will be the element that appears only once in the array.
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
