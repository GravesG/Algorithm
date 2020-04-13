package com.graves.sort;

import java.util.Arrays;

/**
 * @author Graves
 * @title: BubbleSort
 * @projectName Algorithm
 * @description: 冒泡排序
 * @date 2020/4/13 23:13
 */
public class BubbleSort {

    public static void sort(int[] array){
        for(int i = 0; i < array.length -1; i++){
            for(int j = 0; j < array.length-1-i;j++){
                int temp = 0;
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
