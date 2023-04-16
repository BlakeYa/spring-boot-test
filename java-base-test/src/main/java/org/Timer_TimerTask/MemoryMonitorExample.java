package org.Timer_TimerTask;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MemoryMonitorExample {

    public static void main(String[] args) {
        // 创建一个具有1个核心线程的ScheduledThreadPoolExecutor实例
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        // 创建一个Runnable任务，用于监控系统内存使用情况
        Runnable memoryMonitorTask = () -> {
            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
            MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

            System.out.println("Heap memory used: " + heapMemoryUsage.getUsed() + " bytes");
            System.out.println("Non-heap memory used: " + nonHeapMemoryUsage.getUsed() + " bytes");
        };

        // 安排内存监控任务在初始延迟1秒后开始，然后每5秒重复执行一次
        scheduledExecutorService.scheduleAtFixedRate(memoryMonitorTask, 1, 5, TimeUnit.SECONDS);

        // 为了让示例持续运行一段时间，这里让主线程睡眠30秒
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭ScheduledExecutorService，停止接收新的任务，等待已提交任务执行完成后关闭线程池
        scheduledExecutorService.shutdown();
    }
}
