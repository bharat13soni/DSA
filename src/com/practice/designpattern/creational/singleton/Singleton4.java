package com.practice.designpattern.creational.singleton;


/*
 * A journey to write double checked locking of Singleton class in Java.
 */

public class Singleton4 {

    private volatile static Singleton4 _instance;

    private Singleton4() {
        // preventing Singleton object instantiation from outside
    }

    /*
     * 1st version: creates multiple instance if two thread access
     * this method simultaneously
     */

    public static Singleton4 getInstance() {
        if (_instance == null) {
            _instance = new Singleton4();
        }
        return _instance;
    }

    /*
     * 2nd version : this definitely thread-safe and only
     * creates one instance of Singleton on concurrent environment
     * but unnecessarily expensive due to cost of synchronization
     * at every call.
     */

    public static synchronized Singleton4 getInstanceTS() {
        if (_instance == null) {
            _instance = new Singleton4();
        }
        return _instance;
    }

    /*
     * 3rd version : An implementation of double checked locking of Singleton.
     * Intention is to minimize cost of synchronization and  improve performance,
     * by only locking critical section of code, the code which creates
 instance of Singleton class.
     * By the way this is still broken, if we don't make _instance volatile,
 as another thread can
     * see a half initialized instance of Singleton.
     */

    public static Singleton4 getInstanceDC() {
        if (_instance == null) {
            synchronized (Singleton4.class) {
                if (_instance == null) {
                    _instance = new Singleton4();
                }
            }
        }
        return _instance;
    }
}
