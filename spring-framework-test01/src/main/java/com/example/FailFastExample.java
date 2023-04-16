package com.example;

import java.util.ArrayList;
import java.util.Iterator;

public class FailFastExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // 获得迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
//            list.remove();
            iterator.remove();
        }
        System.out.println(list);
    }
}
