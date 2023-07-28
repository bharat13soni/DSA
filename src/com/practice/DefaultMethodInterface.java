package com.practice;

public class DefaultMethodInterface {
    public static void main(String args[]) {
        (new BiLingual1()).converse();
    }
}

interface Language {

    default void sayHello() {
        System.out.println("01101000 01100101 01101100 01101100 01101111 ");
    }
}

interface Marathi1 extends Language {
}

interface Punjabi1 extends Language {
}

class BiLingual1 implements Punjabi1, Marathi1 {
    void converse() {
        sayHello();
    }
}
