package com.graves.sort;

import java.util.Arrays;

/**
 * @author Graves
 * @title: BubbleSort2
 * @projectName Algorithm
 * @description: 冒泡排序-优化
 * @date 2020/4/13 23:13
 */
public class BubbleSort2 {
    public static void sort(int[] array){
        for(int i = 0; i < array.length -1; i++){
            boolean isSorted = true;
            for(int j = 0; j < array.length-1-i;j++){
                int temp = 0;
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    // 因为交换过，所以不是有序的
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
