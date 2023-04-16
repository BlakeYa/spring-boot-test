package org.example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
            it.remove();
        }
        System.out.println(list);
    }

}
