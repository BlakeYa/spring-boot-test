package org.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 创建回调函数对象
        CallbackHandler handler = new CallbackHandler();
        // 提交异步任务并传递回调函数
        executor.execute(new RunnableTask(handler));
        // 关闭线程池
        executor.shutdown();
    }
}

// 回调函数接口
interface Callback {
    void onComplete(String result);
}

// 回调函数实现类
class CallbackHandler implements Callback {
    // 实现回调函数
    public void onComplete(String result) {
        // 处理异步任务执行结果
        System.out.println("CallbackHandler: " + result);
    }
}

// 异步任务类
class RunnableTask implements Runnable {
    private Callback callback;

    public RunnableTask(Callback callback) {
        this.callback = callback;
    }

    public void run() {
        // 异步执行任务
        String result = "hello world";
        // 调用回调函数传递执行结果
        callback.onComplete(result);
    }
}
