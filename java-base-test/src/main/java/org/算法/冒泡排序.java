package org.算法;

import java.sql.SQLOutput;
import java.util.Arrays;

public class 冒泡排序 {

    public static void main(String[] args) {

        int[] arr = {3, 4, 6, 7, 2, 1};

        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                //     swap位置
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
