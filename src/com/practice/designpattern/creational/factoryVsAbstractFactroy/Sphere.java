package com.practice.designpattern.creational.factoryVsAbstractFactroy;

/**
 * Concrete product
 */
public class Sphere implements GeometricShape {
    @Override
    public void draw() {
        System.out.println("Sphere drawn.");
    }
}
