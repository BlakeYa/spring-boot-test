package org.example;

import java.util.Arrays;

public class InsertionSort {

    /**
     * 插入排序算法
     *
     * @param arr 待排序的数组
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 从数组第二个元素开始，将元素插入到前面已排序序列中的合适位置
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            // 将元素与已排序序列中的元素从后往前依次比较，找到合适的位置插入
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
    }
}
