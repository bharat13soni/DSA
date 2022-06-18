package com.practice.array;

public class BitManipulation {
    public static void main(String[] args) {
       /* for (int i = 0; i < 2000; i++) {
            System.out.println(i + " -> " + isEven(i));
//            System.out.println(i + " -> " + isEven1(i));
        }*/
        int a = 2;
        int b = 3;
        swapNumbers(a, b);
        numberOfDigitsInBinaryRepresentation();
        numberOfDigitsDecimalRepresentation();

    }

    static boolean isEven(int n) {
        return ((n & 1) == 0);
    }

    static boolean isEven1(int n) {
        return (n % 2 == 0);
    }

    static boolean isOdd(int n) {
        return ((n & 1) == 1);
    }

    static void swapNumbers(int a, int b) {
        System.out.println("Before swap a -> " + a + " b -> " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swap a -> " + a + " b -> " + b);
    }

    static void numberOfDigitsInBinaryRepresentation() {
        int a = 13;
        System.out.println("numberOfDigitsInBinaryRepresentation ->" + (((int) (Math.log(a) / Math.log(2))) + 1));
    }

    static void numberOfDigitsDecimalRepresentation() {
        int a = 20_000_000;
        System.out.println("numberOfDigitsDecimalRepresentation ->" + (((int) Math.log10(a)) + 1));
    }
}
