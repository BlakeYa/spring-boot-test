package org.example;

import java.util.ArrayList;
import java.util.List;

public class OuterClass {

        private static int x;

        public static class InnerClass {
            public void foo() {
                x = 10; // 访问外部类的静态成员变量
                System.out.println("x = " + x);
            }
        }

        public static void bar() {
            InnerClass inner = new InnerClass(); // 创建静态内部类对象
            inner.foo(); // 调用静态内部类的方法
        }


    public static void main(String[] args) {
        OuterClass.bar();
    }
}
