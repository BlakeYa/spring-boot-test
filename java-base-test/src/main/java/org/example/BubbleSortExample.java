package org.example;

import java.util.Arrays;

/**
 * 冒泡排序算法
 */
public class BubbleSortExample {
    public static void main(String[] args) {
        int[] ar = {3, 5, 2, 1, 6};

        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = 0; j < ar.length - i - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(ar));

    }

}
