package com.practice;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(aPowerB(2, 3));

        System.out.println("josephus(5,3) -> " + josephus(5, 3));
        String s = "racecar";
        System.out.println("isPalindrome(racecar) ->" + isPalindrome(s, 0, s.length() - 1));

        System.out.println("Power set of abc ->");
        powerSetOfString("abc", 0, "");
    }

    static int aPowerB(int a, int b) {
        if (b == 1) {
            return a;
        }
        return a * aPowerB(a, b - 1);
    }

    static int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (josephus(n - 1, k) + k) % n;
    }

    static boolean isPalindrome(String s, int l, int r) {
        if (l >= r) {
            return true;
        }
        if (s.charAt(l) != s.charAt(r)) {
            return false;
        }
        return isPalindrome(s, l + 1, r - 1);
    }

    public static void powerSetOfString(String s, int i, String curr) {
        if (i == s.length()) {
            System.out.println("[ " + curr + " ]");
            return;
        }
        powerSetOfString(s, i + 1, curr + s.charAt(i)); //include current char
        powerSetOfString(s, i + 1, curr); //don't include current char
    }
}
