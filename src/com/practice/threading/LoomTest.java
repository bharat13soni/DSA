package com.practice.threading;

public class LoomTest {
    public static void main(String[] args) {
        System.out.println("Hello Loom");
        Thread.ofVirtual().start(() -> {
            System.out.println("Hello Loom");
        });
    }
}
