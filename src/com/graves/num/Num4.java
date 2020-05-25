package com.graves.num;

/**
 * @author Graves
 * @DESCRIPTION 最大公约数 - 最优解（结合）
 * @create 2020/5/24
 */
public class Num4 {
    public static int getGreatesCommonDivisor(int a, int b) {
        if(a == b){
            return a;
        }
        if((a & 1) == 0 && (b & 1) == 0){
            return getGreatesCommonDivisor(a >> 1,b >> 1) << 1;
        }else if((a&1)==0 && (b&1) != 0){
            return getGreatesCommonDivisor(a >> 1,b);
        }else if ((a&1)!=0 && (b&1) == 0){
            return getGreatesCommonDivisor(a,b >> 1);
        }else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return getGreatesCommonDivisor(big-small,small);
        }
    }

    public static void main(String[] args) {
        System.out.println(getGreatesCommonDivisor(25,5));
        System.out.println(getGreatesCommonDivisor(100,80));
        System.out.println(getGreatesCommonDivisor(27,14));
    }
}
