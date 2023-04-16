package org.Timer_TimerTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {
        // 创建一个具有2个核心线程的ScheduledThreadPoolExecutor实例
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        // 创建一个Runnable任务，打印当前线程名称和当前时间
        Runnable task = () -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", time: " + System.currentTimeMillis());
        };

        // 安排一个Runnable任务在3秒后执行
        scheduledExecutorService.schedule(task, 3, TimeUnit.SECONDS);

        // 安排一个Runnable任务在初始延迟1秒后开始，然后每2秒重复执行一次
        scheduledExecutorService.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        // 安排一个Runnable任务在初始延迟2秒后开始，然后在每次执行完成后等待1秒再重复执行
        scheduledExecutorService.scheduleWithFixedDelay(task, 2, 1, TimeUnit.SECONDS);

        // 为了让示例持续运行一段时间，这里让主线程睡眠10秒
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭ScheduledExecutorService，停止接收新的任务，等待已提交任务执行完成后关闭线程池
        scheduledExecutorService.shutdown();
    }
}
