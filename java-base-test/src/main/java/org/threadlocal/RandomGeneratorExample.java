package org.threadlocal;

import java.util.Random;

public class RandomGeneratorExample {
    // // 创建一个ThreadLocal变量，用于存储每个线程的随机数生成器
    // private static final ThreadLocal<Random> randomThreadLocal = ThreadLocal.withInitial(() -> {
    //     // 随机数生成器的初始化操作
    //     System.out.println("Initializing random generator for thread: " + Thread.currentThread().getName());
    //     return new Random();
    // });
    //
    // public static void main(String[] args) {
    //     // 创建3个线程，每个线程生成10个随机数
    //     for (int i = 0; i < 3; i++) {
    //         new Thread(() -> {
    //             for (int j = 0; j < 10; j++) {
    //                 // 获取当前线程的随机数生成器，并生成一个随机数
    //                 int randomInt = randomThreadLocal.get().nextInt(100);
    //                 System.out.println(Thread.currentThread().getName() + " - Random number: " + randomInt);
    //             }
    //             // 任务完成后，清理ThreadLocal变量，避免内存泄漏
    //             randomThreadLocal.remove();
    //         }).start();
    //     }
    // }

    private static final ThreadLocal<Random> random = ThreadLocal.withInitial(() -> {
        System.out.println("生产随机函数对象操作");
        return new Random();
    });

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    Random random1 = random.get();
                    System.out.println(Thread.currentThread().getName() + ":" + random1.nextInt(100));
                }
                random.remove();
            }).start();

        }
    }
}
