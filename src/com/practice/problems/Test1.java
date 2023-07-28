package com.practice.problems;

public class Test1 {
    public static void main(String[] args) {
        String value = "abc";
        method(value);
        System.out.println(value);
    }

    public static void method(String s) {
        s = "xyz";
    }
}
