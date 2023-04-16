package org.example;


import jdk.nashorn.internal.objects.annotations.Where;

public class MyTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 5;
        int index = binarySearch(arr, target);
        System.out.println(index); // 4
    }

    public static int binarySearch(int[] arr,int target){

        if (arr == null || arr.length == 0 ) {
            return -1;
        }
        int left = 0;
        int right = arr.length-1;

        while (left <= right){
            int mid = (left + right) / 2 ;

            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
