package com.practice;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ProdConsum {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<Integer> sharedQueue = new LinkedBlockingDeque<>();

        Thread producer = new Thread(new Producer(sharedQueue));
        Thread consumer = new Thread(new Consumer(sharedQueue));
        producer.start();
//        producer.join(); //if we want all values to be produced first only then consumer should start
        consumer.start();
    }

}

class Producer implements Runnable {
    private final BlockingDeque<Integer> sharedQueue;

    public Producer(BlockingDeque<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Produced : " + i);
            sharedQueue.add(i);
        }
    }
}

class Consumer implements Runnable {
    private final BlockingDeque<Integer> sharedQueue;

    public Consumer(BlockingDeque<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed : " + sharedQueue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

