package com.graves.num;

/**
 * @author Graves
 * @DESCRIPTION 最大公约数 - 更相减损术
 * @create 2020/5/24
 */
public class Num3 {
    public static int getGreatesCommonDivisor(int a, int b) {
        if(a == b){
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return getGreatesCommonDivisor(big-small,small);
    }

    public static void main(String[] args) {
        System.out.println(getGreatesCommonDivisor(25,5));
        System.out.println(getGreatesCommonDivisor(100,80));
        System.out.println(getGreatesCommonDivisor(27,14));
    }
}
