package com.practice;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SolutionDemo {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Predicate<Integer> isPrime = SolutionDemo::isPrimeNum;
        Arrays.stream(nums).filter(isPrime).forEach(System.out::println);
//        System.out.println(isPrimeNum(4));
    }

    private static boolean isPrimeNum(Integer n) {
        if (n == 0 || n == 1)
            return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime1(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    public static boolean isPrime2(int number) {
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

}
