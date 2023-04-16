package com.example;

public class ErrorTest {
    public static void main(String[] args) {
        try {
            int[] arr = new int[Integer.MAX_VALUE];
        } catch (Error e) {
            if (e instanceof OutOfMemoryError){
                System.out.println("内存溢出");
            } else {
                System.out.println("系统错误");
            }
        }
    }
}