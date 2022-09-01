package com.practice.string;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 */

public class Anagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i : t.toCharArray()) {
            ++count[i - 'a'];
        }

        for (int j : s.toCharArray()) {
            if (--count[j - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("s = \"anagram\", t = \"nagaram\" ->" + isAnagram("anagram", "nagaram"));
        System.out.println("s = \"rat\", t = \"car\" ->" + isAnagram("rat", "car"));
    }

}
