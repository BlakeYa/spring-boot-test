package org.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionExample3 {
    public static void main(String[] args) {
        try {
            // 创建一个示例对象
            Person person = new Person("Alice", 25);

            // 获取 Person 类的 Class 对象
            Class<?> clazz = person.getClass();

            // 获取 Person 类的 name 属性
            Field nameField = clazz.getDeclaredField("name");

            // 设置属性可访问（用于私有属性）
            nameField.setAccessible(true);

            // 获取 name 属性的值
            String name = (String) nameField.get(person);
            System.out.println("Original name: " + name);

            // 设置 name 属性的值
            nameField.set(person, "Bob");
            System.out.println("New name: " + person.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
