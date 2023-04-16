package org.example;

public class 泛型 {
    public static void main(String[] args) {
        Integer[] inArray = {1, 2, 3};
        String[] strArray = {"a", "b" ,"c"};

        printArray(inArray);
        printArray(strArray);
    }

    public static <T> void printArray(T[] arry){
        for (T t : arry) {
            System.out.println(t);
        }
    }
}
