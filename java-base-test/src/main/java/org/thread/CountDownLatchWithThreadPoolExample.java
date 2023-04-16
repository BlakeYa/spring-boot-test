package org.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CountDownLatchWithThreadPoolExample {
    public static void main(String[] args) {
        int numberOfThreads = 5; // 线程数
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        // 创建5个工作线程
        for (int i = 0; i < numberOfThreads; i++) {
            Future<?> future = executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " 开始执行任务");
                try {
                    TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 2000)); // 模拟任务执行时间

                    if (Thread.currentThread().getName().equals("pool-1-thread-4")) {
                        throw new NullPointerException("==========");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " 任务执行完毕");
                    latch.countDown(); // 任务完成后，递减CountDownLatch计数器
                }
            });

            // 处理任务异常
            try {
                future.get();
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "任务执行过程中发生异常：" + e.getMessage());
                latch.countDown(); // 即使发生异常，也要递减计数器，以免主线程一直等待
            }
        }

        System.out.println("等待所有线程完成任务...");

        try {
            latch.await(); // 主线程等待所有工作线程完成任务
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有线程任务已完成，主线程继续执行");

        // 关闭线程池
        executorService.shutdown();
    }
}
