package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("world");
        
        System.out.println("intList: " + intList);
        System.out.println("strList: " + strList);
        
        // 类型擦除，运行时真实类型是不可知的
        List list = intList;
        list.add("hello");
        System.out.println("list: " + list);
        System.out.println("intList: " + intList);
    }
}

