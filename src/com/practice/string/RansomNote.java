package com.practice.string;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstructUsingHashing(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.merge(magazine.charAt(i), 1, (k, v) -> v + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i))) {
                return false;
            } else {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            }
        }
        return true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        int[] store = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            ++store[magazine.charAt(i) - 'a'];
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--store[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("ransomNote = \"a\", magazine = \"b\" -> " + canConstruct("a", "b"));
        System.out.println("ransomNote = \"ab\", magazine = \"aa\" -> " + canConstruct("ab", "aa"));
        System.out.println("ransomNote = \"aa\", magazine = \"aab\" -> " + canConstruct("aa", "aab"));
    }
}
