package com.practice;

public class Demonstration {
    public static void main( String args[] ) {
        question1();
        question2();
        question3();
        question4();
    }
    static void question1() {
        String obj1 = new String("abc");
        String obj2 = new String("abc");
        System.out.println(obj1 == obj2);
    }

    static void question2() {
        String myStr = "abc";
        System.out.println( myStr == "abc");
    }

    static void question3() {
        System.out.println( new Integer(5) == new Integer(5));
    }

    static void question4() {
        System.out.println( 5 == new Integer(5));
    }
}
