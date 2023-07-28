package com.practice;

public class Demo {
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        oc.sayName();
    }
}

class OuterClass {

    String myName = "outerClass";

    private class InnerClass {

        String myName = "innerClass";

        void printName() {
            System.out.println("I am " + myName);
        }
    }

    void sayName() {
        InnerClass ic = new InnerClass();
        ic.printName();
        System.out.println("I am " + myName);
    }
}
