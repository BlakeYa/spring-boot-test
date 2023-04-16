package org.example;

import java.util.Arrays;

public class RadixSortExample {
    // 基数排序主方法
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 获取数组中的最大值
        int max = getMax(arr);

        // 从个位开始，对每一位进行计数排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    // 获取数组中的最大值
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 对指定位数的元素进行计数排序
    private static void countSort(int[] arr, int exp) {
        int[] count = new int[10]; // 计数数组，存放每个位数上 0-9 的计数
        int[] output = new int[arr.length]; // 输出数组，存放排序后的结果

        // 计算每个位数上 0-9 的计数
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // 对计数数组进行累加，得到每个元素在输出数组中的结束位置
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 按照计数数组中的位置信息将原数组元素放入输出数组，保证排序的稳定性
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 将输出数组复制回原数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    // 主函数，测试基数排序
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        radixSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
    }
}
