package org.thread;

public class Buffer {
    private int data = -1; // 缓冲区中的数据
    private boolean empty = true; // 标识缓冲区是否为空

    // 生产数据的方法
    public synchronized void produce(int newData) {
        // 当缓冲区不为空时，生产者线程等待
        while (!empty) {
            try {
                wait(); // 等待消费者消费数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 生产数据
        data = newData;
        empty = false; // 将缓冲区标识为非空
        System.out.println("生产者生产了数据：" + data);
        notify(); // 唤醒消费者线程
    }

    // 消费数据的方法
    public synchronized int consume() {
        // 当缓冲区为空时，消费者线程等待
        while (empty) {
            try {
                wait(); // 等待生产者生产数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 消费数据
        empty = true; // 将缓冲区标识为已空
        System.out.println("消费者消费了数据：" + data);
        notify(); // 唤醒生产者线程
        return data;
    }
}

class BufferTest {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(); // 创建一个缓冲区实例

        // 创建生产者线程
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                try {
                    Thread.sleep((long) (Math.random() * 1000)); // 随机等待一段时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者");

        // 创建消费者线程
        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                try {
                    Thread.sleep((long) (Math.random() * 1000)); // 随机等待一段时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者");

        // 启动生产者和消费者线程
        producerThread.start();
        consumerThread.start();

        // 等待生产者和消费者线程执行完毕
        // try {
        //     // producerThread.join();
        //     // consumerThread.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        System.out.println("生产者-消费者测试完成");
    }


}
