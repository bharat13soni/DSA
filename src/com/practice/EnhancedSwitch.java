package com.practice;

import java.util.Random;

public class EnhancedSwitch {
    public static void main(String[] args) {
        Random random=new Random();
        int number = random.nextInt();
        switch (number) {
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
            case 5 -> System.out.println("5");
            default -> System.out.println(number);
        }
    }

    //write a program to print the number of days in a month using switch case
    public static void printDaysInMonth(int month){
        switch (month) {
            case 1,3,5,7,8,10,12 -> System.out.println("31");
            case 4,6,9,11 -> System.out.println("30");
            case 2 -> System.out.println("28");
            default -> System.out.println("Invalid month");
        }
    }
}
