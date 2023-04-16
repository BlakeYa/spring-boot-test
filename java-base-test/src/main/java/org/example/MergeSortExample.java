package org.example;

import java.util.Arrays;

public class MergeSortExample {
    // 归并排序主方法
    public static void mergeSort(int[] arr) {
        // 如果数组为空或只有一个元素，不需要排序
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    // 使用递归进行归并排序
    private static void mergeSort(int[] arr, int left, int right) {
        // 当左边界大于等于右边界时，说明已经完成排序
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    // 合并两个有序数组
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 创建一个临时数组用于存放合并结果
        int i = left;
        int j = mid + 1;
        int k = 0;

        // 将较小的元素依次放入临时数组
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 将左半边剩余元素放入临时数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 将右半边剩余元素放入临时数组
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将临时数组中的元素复制回原数组
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    // 主函数，测试归并排序
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
    }
}
