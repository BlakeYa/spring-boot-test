package org.example;

public class OuterClass {
    public void foo() {
        int x = 10;

        class InnerClass {
            public void bar() {
                System.out.println("x = " + x);
            }
        }

        InnerClass inner = new InnerClass(); // 创建局部内部类对象
        inner.bar(); // 调用局部内部类的方法


    //     匿名内部类

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello word");
            }
        };
        new Thread(runnable).start();
    }
}