package org.算法;

import java.util.Arrays;
import java.util.WeakHashMap;

public class 快速排序 {


    /**
     * 快速排序算法实现
     *
     * @param arr   待排序的数组
     * @param left  数组左边界
     * @param right 数组右边界
     */
    public static void quickSort(int[] arr, int left, int right) {
        // 递归终止条件，当左右指针相遇或者左指针大于右指针时，返回
        if (left >= right) {
            return;
        }
        // 对数组进行分区，得到基准点位置
        int pivot = partition(arr, left, right);
        // 分治处理左半部分
        quickSort(arr, left, pivot - 1);
        // 分治处理右半部分
        quickSort(arr, pivot + 1, right);
    }

    /**
     * 对数组进行分区
     *
     * @param arr   待分区的数组
     * @param left  数组左边界
     * @param right 数组右边界
     * @return 返回基准点的位置
     */
    public static int partition(int[] arr, int left, int right) {
        // 选择数组左边第一个元素作为基准点
        int pivot = arr[left];
        while (left < right) {
            // 从右边开始找到第一个小于基准点的元素
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // 将找到的小于基准点的元素移动到左边
            arr[left] = arr[right];
            // 从左边开始找到第一个大于基准点的元素
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 将找到的大于基准点的元素移动到右边
            arr[right] = arr[left];
        }
        // 将基准点放到数组的正确位置上
        arr[left] = pivot;
        // 返回基准点的位置
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        // 对数组进行快速排序
        quickSort(arr, 0, arr.length - 1);
        // 输出排序后的数组
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
    }
}
