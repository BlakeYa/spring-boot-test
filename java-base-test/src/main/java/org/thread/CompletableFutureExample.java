package org.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 提交异步任务并获取CompletableFuture对象
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new SupplierTask(), executor);
        // 异步任务执行完成后调用回调函数处理结果
        future.thenAccept(result -> {
            // 处理异步任务执行结果
            System.out.println(result);
        });

        // 关闭线程池
        executor.shutdown();
    }
}

// 异步任务类
class SupplierTask implements Supplier<String> {
    @Override
    public String get() {
        // 异步执行任务
        return "hello world";
    }
}
