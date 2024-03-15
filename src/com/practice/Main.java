package com.practice;

public class Main {
    public static int countSubstring(String str, String subStr) {
        int count = 0;
        int idx = 0;

        while ((idx = str.indexOf(subStr, idx)) != -1) {
            count++;
            idx += subStr.length();
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "Hello, world! The world is beautiful. World peace is important.";
        String subStr = "world";
        System.out.println(countSubstring(str, subStr));  // Output: 3
    }
}