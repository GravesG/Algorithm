package com.graves.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Graves
 * @DESCRIPTION 快速排序-非递归法
 * @create 2020/5/13
 */
public class QuickSort3 {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // 真个数列的起止下标，以哈希的形式入栈
        Map rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        // 循环结束条件：栈为空
        while (!quickSortStack.isEmpty()) {
            // 栈顶元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            // 得到基准元素位置
            int pivotIndex = partition(arr, param.get("startIndex"), param.get("endIndex"));
            // 根据基准元素分成两个部分，吧每部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParams = new HashMap<>();
                leftParams.put("startIndex", param.get("startIndex"));
                leftParams.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParams);
            }
            if (param.get("endIndex") > pivotIndex + 1) {
                Map<String, Integer> rightParams = new HashMap<>();
                rightParams.put("startIndex", pivotIndex + 1);
                rightParams.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParams);
            }
        }
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
        int[] arr = new int[]{
                4, 4, 6, 5, 3, 2, 8, 1
        };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
