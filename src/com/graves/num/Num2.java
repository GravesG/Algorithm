package com.graves.num;

/**
 * @author Graves
 * @DESCRIPTION 最大公约数 - 辗转相除（欧几里得算法）
 * @create 2020/5/24
 */
public class Num2 {
    public static int getGreatesCommonDivisor(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if(big%small == 0){
            return small;
        }
        return getGreatesCommonDivisor(big%small,small);
    }

    public static void main(String[] args) {
        System.out.println(getGreatesCommonDivisor(25,5));
        System.out.println(getGreatesCommonDivisor(100,80));
        System.out.println(getGreatesCommonDivisor(27,14));
    }
}
