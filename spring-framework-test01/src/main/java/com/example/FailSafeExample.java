package com.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;

public class FailSafeExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");

        // 启动一个新线程，对map进行修改
        new Thread(() -> {
            try {
                Thread.sleep(22L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            map.put("D", "4");
            map.put("E", "5");
            map.put("A", "6");
        }).start();

        // 获得迭代器
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {

            String next = iterator.next();
            System.out.println(next + "," + map.get(next));
        }
    }
}
