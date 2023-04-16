package org.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        int numberOfThreads = 5; // 线程数
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        // 创建5个工作线程
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 开始执行任务");
                try {
                    Thread.sleep((long) (Math.random() * 2000)); // 模拟任务执行时间
                    throw new NullPointerException("exception........");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    System.out.println(Thread.currentThread().getName() + " 任务执行完毕");
                    latch.countDown(); // 任务完成后，递减CountDownLatch计数器

            }, "线程" + (i + 1)).start();
        }

        System.out.println("等待所有线程完成任务...");

        try {
            latch.await(); // 主线程等待所有工作线程完成任务
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有线程任务已完成，主线程继续执行");
    }
}
