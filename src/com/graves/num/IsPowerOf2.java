package com.graves.num;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author Graves
 * @DESCRIPTION 是否是2的整数幂 - O(1)
 * @create 2020/5/25
 */
public class IsPowerOf2 {

    public static boolean isPowerOf2(int num) {
        return (num & num - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(2));
        System.out.println(isPowerOf2(8));
        System.out.println(isPowerOf2(10));
    }

}
