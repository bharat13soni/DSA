package com.practice.designpattern.creational.singleton;

public class Demo {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();
        System.out.println("singleton1 -> " + singleton1.hashCode());
        System.out.println("singleton2 -> " + singleton2.hashCode());

        Singleton2 singleton21 = Singleton2.INSTANCE;
        Singleton2 singleton22 = Singleton2.INSTANCE;
        System.out.println("singleton21 ->" + singleton21.hashCode());
        System.out.println("singleton22 ->" + singleton22.hashCode());

        Singleton3 singleton31 = Singleton3.getInstance();
        Singleton3 singleton32 = Singleton3.getInstance();
        System.out.println("singleton31 ->" + singleton31.hashCode());
        System.out.println("singleton31 ->" + singleton32.hashCode());
    }
}
