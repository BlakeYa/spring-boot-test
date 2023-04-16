package org.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample2 {
    public static void main(String[] args) {
        try {
            // 获取 String 类的 Class 对象
            Class<?> clazz = String.class;
            Class<?> aClass = Class.forName("org.reflect.User");

            // 获取 String 类的 toUpperCase 方法
            Method toUpperCaseMethod = clazz.getMethod("toUpperCase");

            // 创建一个 String 实例
            String myString = "hello world";

            // 通过反射调用 toUpperCase 方法
            String upperCaseString = (String) toUpperCaseMethod.invoke(myString);

            // 输出结果
            System.out.println(upperCaseString); // 输出：HELLO WORLD
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
