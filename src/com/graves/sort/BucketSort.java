package com.graves.sort;

import javax.xml.bind.Element;
import java.util.*;

/**
 * @author Graves
 * @DESCRIPTION 桶排序
 * @create 2020/5/19
 */
public class BucketSort {
    public static double[] bucketSort(double[] array) {
        // 1.得到数列最大值和最小值，并计算差值d
        double max = array[0];
        double min = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;

        // 2.初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        // 3.遍历原始数组，将每个元素放入桶中
        for(int i = 0;i<array.length;i++){
            int num = (int) ((array[i]-min) *(bucketNum-1)/d);
            bucketList.get(num).add(array[i]);
        }

        // 4.对桶内部进行排序
        for (int i = 0; i < bucketList.size();i++){
            // JDK底层进行了归并排序或者归并排序的优化版本
            Collections.sort(bucketList.get(i));
        }

        // 5.输出全部元素
        double[] sorted = new double[array.length];
        int index= 0;
        for (LinkedList<Double> list : bucketList){
            for (double element : list){
                sorted[index] = element;
                index++;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        double[] array = new double[]{
                4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09
        };
        double[] sorted = bucketSort(array);
        System.out.println(Arrays.toString(sorted));
    }
}
