package com.graves.sort;

import java.util.Arrays;

/**
 * @author Graves
 * @DESCRIPTION 快速排序-单边法
 * @create 2020/5/13
 */
public class QuickSort2 {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大于或等于EndIndex
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    public static int partition(int[] arr, int startIndex, int endIndex) {
        // 去第一个位置（或者随机位置）为基准
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        // pivot和指针重合点交换
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;

        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                4,4,6,5,3,2,8,1
        };
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
