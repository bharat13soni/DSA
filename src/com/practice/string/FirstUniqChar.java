package com.practice.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public static int firstUniqCharUsingHashing(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char item : chars) {
            map.merge(item, 1, (k, v) -> v + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar(String s) {
        // Base case...
        if (s.length() == 0) return -1;
        // To keep track of the count of each character, we initialize an int[]store with size 26...
        int[] store = new int[26];
        // Traverse string to keep track number of times each character in the string appears...
        for (char ch : s.toCharArray()) {
            store[ch - 'a']++;      // To access the store[] element representative of each character, we subtract ‘a’ from that character...
        }
        // Traverse string again to find a character that appears exactly one time, return it’s index...
        for (int idx = 0; idx < s.length(); idx++) {
            if (store[s.charAt(idx) - 'a'] == 1) {
                return idx;
            }
        }
        return -1;      // if no character appeared exactly once...
    }

    public static void main(String[] args) {
        System.out.println("leetcode -> " + firstUniqChar("leetcode"));
        System.out.println("loveleetcode -> " + firstUniqChar("loveleetcode"));
        System.out.println("aabb -> " + firstUniqChar("aabb"));
    }
}
