package com.practice.mathematics;

public class GuessNumber {
    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     * int guess(int num);
     */

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int pick = (low + (high - low) / 2);
            int res = guess(pick);
            if (res == 0) {
                return pick;
            } else if (res == 1) {
                low = pick + 1;
            } else {
                high = pick - 1;
            }
        }
        return -1;
    }

    private int guess(int pick) {
        //dummy
        return 0;
    }
}
