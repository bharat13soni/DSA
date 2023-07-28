package com.practice.designpattern.creational.singleton;

public class Singleton3 {
    private static volatile Singleton3 instance;

    private Singleton3() {
        if (instance != null) {
            throw new IllegalStateException("Instance already present!!");
        }
    }

    public Object readResolve() {
        return instance;
    }

    @Override
    public Singleton1 clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
