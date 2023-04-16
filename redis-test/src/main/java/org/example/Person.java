package org.example;

import java.io.*;

public class Person implements Serializable {
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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 序列化
        Person person = new Person("Tom", 20);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.txt"));
        out.writeObject(person);
        out.close();

        // 反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.txt"));
        Person person2 = (Person) in.readObject();
        in.close();

        System.out.println(person2.getName()); // Tom
        System.out.println(person2.getAge()); // 20
    }
}
