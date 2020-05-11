package com.graves.sort;

import java.util.Arrays;

/**
 * @author Graves
 * @DESCRIPTION 鸡尾酒排序
 * @create 2020/5/11
 */
public class BubbleSort4 {

    public static void sort(int array[]){
        int temp = 0;
        for(int i=0; i<array.length/2;i++){
            // 有序标记，每一轮的初始值都为true
            boolean isSorted = true;
            // 奇数轮，从左往右比较交换
            for(int j=i;j<array.length-i-1;j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    // 有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
            // 在偶数轮之前,将isSorted重新标记为true
            isSorted = true;
            // 偶数轮，从右往左比较
            for(int j = array.length-i-1;j>i;j--){
                if(array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    // 有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {
                2,3,4,5,6,7,8,1
        };
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
