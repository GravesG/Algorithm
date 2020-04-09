package com.graves.tree;

import java.util.Arrays;

/**
 * @author Graves
 * @title: TreeNodeTest04
 * @projectName Algorithm
 * @description: 二叉堆
 * @date 2020/4/9 23:09
 */
public class TreeNodeTest04 {

    /**
     * @return void
     * @Author Graves
     * @Description 上浮调整
     * @Date 23:10
     * @Param []
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        // temp保存插入得叶子节点值，用于最后得赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            //无需真正交换，单项赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * @return void
     * @Author Graves
     * @Description 下沉调整
     * @Date 23:20
     * @Param [array, parentIndex, length]
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点，用于最后赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子的值，则直接跳出
            if (temp <= array[childIndex]) {
                break;
            }
            // 无需真正的交换，单项赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
    * @Author Graves
    * @Description 构建堆
    * @Date  23:34
    * @Param [array]
    * @return void
    */
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，一次做下沉调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array,i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
