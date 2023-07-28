package com.practice.designpattern.creational.singleton;

import java.io.Serializable;

public class Singleton1 implements Serializable, Cloneable {
    //Thread Safe Singleton using Static field Initialization
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
        if (instance != null) {
            throw new IllegalStateException("Instance already present!!");
        }
    }

    public Object readResolve() {
        return instance;
    }

    public static Singleton1 getInstance() {
        return instance;
    }

    @Override
    public Singleton1 clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
