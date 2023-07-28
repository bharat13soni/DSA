package com.practice;

public class LongestConsecutiveZeroes {

    /**
     * Time Complexity: O(log2N)
     * Auxiliary Space: O(1)
     *
     * Input  : N = 14
     * Output : 1
     * Binary representation of 14 is
     * 1110. There is only one 0 in
     * the binary representation.
     *
     * Input : N = 9
     * Output : 2
     */
    public static int longestConsecutiveZeroesInBinaryRep(int n) {
        // variable to store the length of
        // the longest consecutive 0's
        int max = -1;

        // to temporary store the consecutive 0's
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 0) {
                count++;
                n >>= 1;
                max = Math.max(max, count);
            } else {
                max = Math.max(max, count);
                count = 0;
                n >>= 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int N = 14;
        System.out.println(longestConsecutiveZeroesInBinaryRep(N));
    }
}
