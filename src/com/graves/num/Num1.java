package com.graves.num;

/**
 * @author Graves
 * @DESCRIPTION 最大公约数 - 暴力搜
 * @create 2020/5/24
 */
public class Num1 {
    public static int getGreatesCommonDivisor(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if(big%small == 0){
            return small;
        }

        for(int i = small/2; i > 1; i--){
            if(small % i == 0 && big % i == 0){
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(getGreatesCommonDivisor(25,5));
        System.out.println(getGreatesCommonDivisor(100,80));
        System.out.println(getGreatesCommonDivisor(27,14));
    }
}
