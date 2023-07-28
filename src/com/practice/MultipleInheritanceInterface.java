package com.practice;

public class MultipleInheritanceInterface {
    public static void main(String[] args) {
        (new TeslaModelX()).identifyMyself();
    }
}

interface Vehicle {

    default void whatAmI() {
        System.out.println("I am a vehicle");
    }
}

interface SevenSeater extends Vehicle {
}

interface SUV extends Vehicle {

    default void whatAmI() {
        System.out.println("I am a SUV");
    }
}

class TeslaModelX implements SUV, SevenSeater {

    public void identifyMyself() {
        whatAmI();
    }
}
