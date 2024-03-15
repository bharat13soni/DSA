package com.practice.threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] workerThreads;

    public CustomThreadPool(int numThreads) {
        taskQueue = new LinkedBlockingQueue<>();
        workerThreads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            workerThreads[i] = new Worker("Custom Pool Thread " + (i + 1));
            workerThreads[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    private class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        public void run() {
            Runnable task;

            while (true) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = taskQueue.poll();
                }

                try {
                    task.run();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}