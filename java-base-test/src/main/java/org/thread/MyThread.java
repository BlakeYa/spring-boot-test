package org.thread;

import javax.management.relation.RelationNotFoundException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
 class Test {
    public static void main(String[] args) throws Exception {
        MyThread t = new MyThread();
        t.start();

        MyRunable runable = new MyRunable();
        new Thread(runable).start();

        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }
}

class MyRunable implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("===="+Thread.currentThread().getName() + ":" + i);
        }
    }
}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 1; i <= 5; i++) {
            System.out.println("******"+Thread.currentThread().getName() + ":" + i);
        }
        return "hello blake";
    }
}

