package com.practice;

public class InheritanceDemo {
    public static void main(String args[]) {

//        (new Spanish()).sayHello();

//        Language1 lg = new Spanish();
//        lg.sayHello();
        Spanish.printLanguage();
    }
}

class Language1 {

    static String lang = "base language";

    static protected void printLanguage() {
        System.out.println(lang);
    }

    protected Language1 sayHello() {
        System.out.println("----");
        return this;
    }
}

class Spanish extends Language1 {

    static String lang = "Spanish";

    static protected void printLanguage() {
        System.out.println(lang);
    }

    protected Language1 sayHello() {
        System.out.println("Ola!");
        return this;
    }
}
