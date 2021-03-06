package com.graves.sort;

import java.util.Arrays;

/**
 * @author Graves
 * @DESCRIPTION 冒泡排序优化2
 * @create 2020/5/10
 */
public class BubbleSort3 {

    public static void sort(int array[]) {
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较都需要比到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if(array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    // 因为有元素进行交换，所以不是有序的，标记变为false
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {
            3,4,2,1,5,6,7,8
        };
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
