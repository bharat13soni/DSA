package com.practice.designpattern.creational.factoryVsAbstractFactroy;

/**
 * Abstract Factory
 */
public abstract class AbstractFactory {
    abstract GeometricShape getShape(ShapeType name);
}
