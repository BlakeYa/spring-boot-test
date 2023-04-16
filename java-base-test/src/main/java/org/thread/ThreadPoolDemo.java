package org.thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        // 创建线程池，大小为2
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ExecutorService executorService2 = Executors.newWorkStealingPool();

        // 提交10个任务给线程池执行
        for (int i = 1; i <= 10; i++) {
            Future<?> submit = executor.submit(new Task(i));
            executor.execute( new Task(i));
        }

        // 关闭线程池
        executor.shutdown();
    }

    // 任务类
    static class Task implements Runnable {
        private int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

       static void print(){
           System.out.println("hello,线程："+Thread.currentThread().getName());
       }

        @Override
        public void run() {
            try {
                Thread.sleep(1000L);
                print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
