package com.practice.mathematics;

import java.util.Arrays;

public class MathematicsProblems {
    public static void main(String[] args) {
        System.out.println("noOfTrailingZerosInFactorial(5) =>" + noOfTrailingZerosInFactorial(5));
        System.out.println("noOfTrailingZerosInFactorial(35) =>" + noOfTrailingZerosInFactorial(35));

        System.out.println("isPalindrome(353) =>" + isPalindrome(353)); //TRUE
        System.out.println("isPalindrome(-121) =>" + isPalindrome(-121)); //FALSE

        boolean[] isPrime = sieveOfEratosthenes(20);
        for (int i = 0; i < isPrime.length; i++) {
            System.out.println(i + " is prime -> " + isPrime[i]);
        }

        System.out.println("gcd of 60,24 is ->" + gcd(24, 60));
        System.out.println("Power(3,5) -> " + fastPower(3, 5));
    }

    public static int noOfTrailingZerosInFactorial(int n) {
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res = res + n / i;
        }
        return res;
    }

    public static boolean isPalindrome(int n) {
        int num = n;
        int reverse = 0;
        while (n > 0) {
            reverse = (10 * reverse) + (n % 10);
            n = n / 10;
        }
        System.out.println("num =>" + num);
        System.out.println("reverse =>" + reverse);
        return num == reverse;
    }

    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int fastPower(int a, int b) {
        int res = 1;
        while (b > 0) {
            //check if b is odd
            if ((b & 1) != 0) {
                res = res * a;
            }
            a = a * a;
            b = b >> 1; // Right shift by 1-> divide b by 2  (Left shift by 1-> multiply b by 2  )
        }
        return res;
    }


}
