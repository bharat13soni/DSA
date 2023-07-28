package com.practice;

class IntegerSwap {
    public static void main(String[] args) {
//        (new IntegerSwap()).run();
        String[] students = new String[10];
        String studentName = "You are an awesome developer";
        students[0] = studentName;
        studentName = null;
        System.out.println(students[0]);
    }
  
    public void run() {
        Integer x = 5;
        Integer y = 9;
        System.out.println("Before Swap x : " + x + " y : " + y);
        swap(x, y);
        System.out.println("After Swap x : " + x + " y : " + y);
    }

    private void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }  
}
