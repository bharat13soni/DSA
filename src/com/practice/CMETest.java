package com.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CMETest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Thread t1 = new Thread(() -> {
            Iterator<Integer> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                Integer number = iterator.next();
                System.out.println(number);
            }
            System.out.println("Thread : " + Thread.currentThread().getName() + " -> " + numbers);

        });
        Thread t2 = new Thread(() -> {
            Iterator<Integer> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == 2)
                    numbers.remove(1);
            }
            System.out.println("Thread : " + Thread.currentThread().getName() + " -> " + numbers);
        });


        t1.start();
        t2.start();
    }
}
