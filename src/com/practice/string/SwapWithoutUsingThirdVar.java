package com.practice.string;

public class SwapWithoutUsingThirdVar {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "World";
        System.out.println("Before swapping a= " + a + " and b= " + b);
        //1. append a+b
        a = a + b; //HelloWorld
        //2. store initial string in b
        b = a.substring(0, a.length() - b.length());
        //3. store remaining string in a
        a = a.substring(b.length());
        System.out.println("After swapping a= " + a + " and b= " + b);

    }
}
