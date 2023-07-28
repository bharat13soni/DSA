package com.practice;

class LocalClassExample {
    public static void main(String[] args) {

        String name = "mainClass";

        // Declare our local class
        class LocalClass {
            String myName = "superFineLocalClass";

            public LocalClass(String name) {
                this.myName = name;
            }

            public void print() {
                System.out.println("My name is " + myName + " and I am enclosed by " + name);
            }
        }


        LocalClass lc1 = new LocalClass("test");
        LocalClass lc2 = new LocalClass("rest");

        lc1.print();
        lc2.print();      

      }
}
