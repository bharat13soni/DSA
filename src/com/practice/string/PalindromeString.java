package com.practice.string;

public class PalindromeString {

    /**
     * Approach: Our approach will be that we will first convert the string to lowercase.
     * Then, we will take two pointers i pointing to the start of the string and j pointing to the end of the string.
     * Keep incrementing i and decrementing j while i < j and at every step check whether the characters at these pointers are the same or not.
     * If not then the string is not a palindrome else it is.
     * <p>
     * Time Complexity:- The time complexity of the given code is O(n), where n is the length of the input string.
     * This is because the while loop iterates through half of the string to check if it is a palindrome.
     * Since we only check half of the string, the number of iterations is proportional to n/2, which is O(n).
     * <p>
     * Space Complexity:- The space complexity of the code is O(1), because the code only uses a constant amount of additional space
     * that is independent of the input size. The only variables used in the code are i, j, and str, which each take up a constant amount of space.
     * No additional space is created in the code.
     */
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

        System.out.println(isWordPalindromeUsingRecursion("abba"));
    }

    /**
     * Recursive approach: The approach is very simple. Just like the two-pointer approach, we will check the first and the last value of the string but this time it will be through recursion.
     *
     * We will take two pointers i pointing to the start of the string and j pointing to the end of the string.
     * Keep incrementing i and decrementing j while i < j and at every step
     * Check whether the characters at these pointers are the same or not. We are doing this through recursion – (i+1, j-1
     * If all the characters are the same on the ith and jth index till i>=j condition satisfies, print true else false
     */
    public static boolean isPalindromeRec(int i, int j, String A) {
        // comparing the two pointers
        if (i >= j) {
            return true;
        }

        // comparing the characters on those pointers
        if (A.charAt(i) != A.charAt(j)) {
            return false;
        }

        // checking everything again recursively
        return isPalindromeRec(i + 1, j - 1, A);
    }

    public static boolean isPalindrome1(String A) {
        return isPalindromeRec(0, A.length() - 1, A);
    }

    public static boolean isPalindromeStr(String str) {
        // Initializing an empty string to store the reverse
        // of the original str
        StringBuilder rev = new StringBuilder();

        // Initializing a new boolean variable for the
        // answer
        boolean ans = false;

        for (int i = str.length() - 1; i >= 0; i--) {
            rev.append(str.charAt(i));
        }

        // Checking if both the strings are equal
        if (str.equals(rev.toString())) {
            ans = true;
        }
        return ans;
    }

    public static boolean isWordPalindromeUsingRecursion(String word) {
        String reverseWord = getReverseWord(word);
        //if word equals its reverse, then it is a palindrome
        System.out.println("reverseWord -> " + reverseWord);
        return word.equals(reverseWord);
    }

    public static String getReverseWord(String word) {
        System.out.println("word -> " + word);
        if (word == null || word.isEmpty()) {
            return word;
        }

        return word.charAt(word.length() - 1) + getReverseWord(word.substring(0, word.length() - 1));
    }
}
