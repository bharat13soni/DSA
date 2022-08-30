package com.practice.string;

public class PalindromeString {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (Character.toLowerCase(chars[l++]) != Character.toLowerCase(chars[r--])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("A man, a plan, a canal: Panama ->" + isPalindrome("A man, a plan, a canal: Panama"));
    }
}
