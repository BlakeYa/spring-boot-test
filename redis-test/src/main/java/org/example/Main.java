package org.example;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        System.out.println(dayOfWeek.isWeekend());

        // Set<String> set = new TreeSet<>();
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        set.add("banana");
        set.add("orange");
        set.add("apple");
        System.out.println(set); // [apple, banana, orange]



        // 删除指定元素
        set.remove("apple");
        System.out.println(set); // [banana, orange]

        // 判断元素是否存在
        boolean contains = set.contains("banana");
        System.out.println(contains); // true

        // 获取元素的个数
        int size = set.size();
        System.out.println(size); // 2

        // Integer[] numbers = {5, 3, 8, 1, 6, 4, 7, 2};
        //
        // // 使用Lambda表达式进行自然排序（升序）
        // Integer[] sortedAscending = Arrays.stream(numbers)
        //         .sorted()
        //         .toArray(Integer[]::new);
        // System.out.println("Ascending order: " + Arrays.toString(sortedAscending));
        //
        // // 使用Lambda表达式进行降序排序
        // Integer[] sortedDescending = Arrays.stream(numbers)
        //         .sorted(Comparator.reverseOrder())
        //         .toArray(Integer[]::new);
        // System.out.println("Descending order: " + Arrays.toString(sortedDescending));
        //
        // // 对字符串数组进行排序
        // String[] names = {"John", "Alice", "Zoe", "Bob", "Marry", "Tom"};
        // String[] sortedNames = Arrays.stream(names)
        //         .sorted()
        //         .toArray(String[]::new);
        // System.out.println("Sorted names: " + Arrays.toString(sortedNames));
        //
        // // 使用自定义排序规则（如字符串长度）
        // String[] sortedByLength = Arrays.stream(names)
        //         .sorted(Comparator.comparingInt(String::length).reversed())
        //         .toArray(String[]::new);
        // System.out.println("Sorted by length: " + Arrays.toString(sortedByLength));
    }

}
