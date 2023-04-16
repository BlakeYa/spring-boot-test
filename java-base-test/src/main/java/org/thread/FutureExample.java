package org.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 提交异步任务并获取Future对象
        Future<String> future = executor.submit(new CallableTask());
        // 阻塞等待异步任务执行完成并获取结果
        String result = future.get();
        // 处理异步任务执行结果
        System.out.println(result);
        // 关闭线程池
        executor.shutdown();
    }
}

// 异步任务类
class CallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        // 异步执行任务
        return "hello world";
    }
}
