package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
    private static final int QUEUE_SIZE = 10;
    private static final int PRODUCER_COUNT = 5;
    private static final int CONSUMER_COUNT = 3;

    public static void main(String[] args) {
        // 创建阻塞队列
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(QUEUE_SIZE);

        // 创建生产者线程
        for (int i = 1; i <= PRODUCER_COUNT; i++) {
            Runnable producerThread = new Runnable() {
                @Override
                public void run() {
                    try {
                        int value = 0;
                        while (true) {
                            // 生产元素并将其放入队列
                            queue.put(value);
                            System.out.println("Producer " + Thread.currentThread().getId() + " produced " + value);
                            value++;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(producerThread).start();
        }

        // 创建消费者线程
         for (int i = 1; i <= CONSUMER_COUNT; i++) {
            Thread consumerThread = new Thread(() -> {
                try {
                    while (true) {
                        // 从队列中取出元素并进行消费
                        int value = queue.take();
                        System.out.println("Consumer " + Thread.currentThread().getId() + " consumed " + value);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            consumerThread.start();
        }
    }
}