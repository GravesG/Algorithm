package com.graves.sort;

import java.util.Arrays;

/**
 * @author Graves
 * @DESCRIPTION 快速排序-双边法
 * @create 2020/5/12
 */
public class QuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件： startIndex >= endIndex 时
        if (startIndex >= endIndex) {
            return;
        }

        // 得到基准位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    public static int partition(int[] arr, int startIndex, int endIndex){
        // 去第一个位置（或者随机位置）为基准
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right){
            // 控制right指针比较并左移
            while (left<right && arr[right] > pivot){
                right--;
            }
            // 控制left指针并向右移
            while (left < right && arr[left] <= pivot){
                left++;
            }
            // 交换left和right指针指向的元素
            if(left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
            4,4,6,5,3,2,8,1
        };
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
