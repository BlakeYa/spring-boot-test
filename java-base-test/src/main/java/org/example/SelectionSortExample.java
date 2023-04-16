package org.example;

import java.util.Arrays;

/**
 * 选择排序示例
 */
public class SelectionSortExample {

    /**
     * 选择排序算法
     *
     * @param arr 待排序数组
     */
    public static void selectionSort(int[] arr) {
        // 如果数组为null或长度小于2，不需要排序
        if (arr == null || arr.length < 2) {
            return;
        }
        // 外层循环控制每次选择的起始位置，从0开始到length-2
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // 假设当前位置的元素是最小的
            // 内层循环找到当前位置之后最小的元素
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // 更新最小元素的下标
                }
            }
            // 如果当前位置不是最小元素的位置，则交换当前位置和最小位置的元素
            if (minIndex != i) {
                int temp = arr[i];
                //
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
    }
}



