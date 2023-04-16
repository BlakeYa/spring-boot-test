package org.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>(); // 用LinkedList作为缓冲区
        int capacity = 3; // 缓冲区容量

        ReentrantLock lock = new ReentrantLock(); // 创建一个可重入锁
        Condition notFull = lock.newCondition(); // 创建一个表示缓冲区未满的条件
        Condition notEmpty = lock.newCondition(); // 创建一个表示缓冲区非空的条件

        // 生产者线程
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                lock.lock();
                try {
                    while (buffer.size() == capacity) {
                        notFull.await(); // 等待缓冲区未满
                    }
                    buffer.add(i);
                    System.out.println("生产者生产了数据：" + i);
                    notEmpty.signal(); // 通知消费者缓冲区非空
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者");

        // 消费者线程
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                lock.lock();
                try {
                    while (buffer.isEmpty()) {
                        notEmpty.await(); // 等待缓冲区非空
                    }
                    int data = buffer.remove();
                    System.out.println("消费者消费了数据：" + data);
                    notFull.signal(); // 通知生产者缓冲区未满
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者");

        // 启动生产者和消费者线程
        producer.start();
        consumer.start();
    }
}
