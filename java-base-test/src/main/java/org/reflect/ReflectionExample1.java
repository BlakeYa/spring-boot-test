package org.reflect;

import java.lang.reflect.Constructor;
import java.util.List;

public class ReflectionExample1 {
    public static void main(String[] args) {
        try {
            // 通过完全限定名获取 Class 对象
            Class<?> clazz = Class.forName("java.util.ArrayList");

            // 使用无参构造函数创建对象实例
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // 将对象实例转换为具体类型
            List<String> list = (List<String>) instance;

            // 使用对象实例
            list.add("Hello");
            list.add("World");
            System.out.println(list);

        //     ============
            User myUser = new MyUser();
            myUser.setAge(2);
            myUser.setUserName("blake-sun");

            checkUser(myUser);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkUser(User myUser) {
        if (myUser instanceof MyUser) {
            System.out.println("you are myUser object");
        } else  {
            System.out.println("you are user object");
        }
    }
}
