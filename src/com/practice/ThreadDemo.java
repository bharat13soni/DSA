package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<Integer> task = () -> {
            Random random = new Random();
            int i = random.nextInt();
            System.out.println("inside callable ->" + i + " thread : " + Thread.currentThread().getName());
            return i;
        };
        Callable<Integer> task2 = () -> {
            Random random = new Random();
            int i = random.nextInt();
            System.out.println("inside callable ->" + i + " thread : " + Thread.currentThread().getName());
            return i;
        };
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(task);
        tasks.add(task2);
        List<Future<Integer>> futures = executorService.invokeAll(tasks);

        try {
            for (int i = 0; i < tasks.size(); i++) {
                Integer res = futures.get(i).get();
                System.out.println("res ->" + res + " thread : " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
