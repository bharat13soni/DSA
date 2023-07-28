package com.practice;

public class StaticMethodInterface implements InterfaceWithStaticMethod {
    public static void main(String[] args) {
        printName();
        InterfaceWithStaticMethod.printName();
    }

    public static void printName() {
        System.out.println("Demonstration class");
    }
}


interface InterfaceWithStaticMethod {

    static void printName() {
        System.out.println("Interface with InterfaceWithStaticMethod");
    }

}
