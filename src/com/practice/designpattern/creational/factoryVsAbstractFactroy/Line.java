package com.practice.designpattern.creational.factoryVsAbstractFactroy;

/**
 * Concrete Product
 */
public class Line implements GeometricShape {
    @Override
    public void draw() {
        System.out.println("Line Drawn.");
    }
}
