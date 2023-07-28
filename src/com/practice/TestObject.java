package com.practice;

public class TestObject {
    public static void main( String args[] ) {
        myMethod(new Integer(5));
        myMethod("abc");
    }

    static void myMethod(Object input) {

        System.out.println("class name: " + input.getClass().getSimpleName());
        System.out.println("super class name: " + input.getClass().getSuperclass().getSimpleName());
        System.out.println("# of interfaces implemented: " + input.getClass().getSuperclass().getInterfaces().length);
        System.out.println();
    }
}
