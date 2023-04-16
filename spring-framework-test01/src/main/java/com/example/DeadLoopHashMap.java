package com.example;

import java.util.HashMap;

public class DeadLoopHashMap {
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    map.put(1, 1);
                    System.out.println("map put");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    map.get(1);
                    System.out.println("map get");
                }
            }
        }).start();
    }
}
