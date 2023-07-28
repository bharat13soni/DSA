package com.practice;

interface Marathi {

    String lang = "marathi";

    default void sayHello() {
        System.out.println("Namaskaar");
    }

}

interface Punjabi {

    String lang = "punjabi";

    default void sayHello() {
        System.out.println("O Kiddaan");
    }

}

class Kashmiri {

    String lang = "kashmiri";

    public void sayHello() {
        System.out.println("aadaab");
    }
}

public class Trilingual extends Kashmiri implements Punjabi, Marathi {

    public static void main(String[] args) {
        new Trilingual().converse();
    }
    public void converse() {
        // invokes Kashmiri class's sayHello method
        sayHello();

        // invokes default implementation of the Punjabi interface
        Punjabi.super.sayHello();

        // invokes default implementation of the Marathi interface
        Marathi.super.sayHello();
    }
}
