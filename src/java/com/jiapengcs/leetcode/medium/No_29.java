package com.jiapengcs.leetcode.medium;

import java.util.Date;

/**
 * Created by Jiapeng 2017/10/12.
 *
 * 29. Divide Two Integers
 *
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 *
 * 分析：不使用乘、除、取模运算实现除法运算。
 * 方法一：暴力法，先记录符号位，取两个数的绝对值，循环减去除数。（效率低，超时）
 * 方法二：二分法，先尝试从被除数减去2^31个除数，如果不够减，则尝试减去2^30个除数...直到被除数小于除数。
 *
 * TODO: 用位运算实现加、减、乘、除。
 */
public class No_29 {
    public static int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1 || divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int answer = 0;
        int sign = (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) ? -1 : 1;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);
        while (x >= y) {
            x -= y;
            answer++;
        }
        return sign * answer;
    }

    public static int divide(int dividend, int divisor) {
        int sign = (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) ? -1 : 1;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);
        long answer = 0;
        int index = 32;
        while (--index >= 0 && x >= y) {
            if ((x >> index) >= y) {
                answer += ((long) 1 << index);
                x -= (y << index);
            }
        }
        answer *= sign;
        if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) answer;
    }

    public static void main(String[] args) {
        long start = new Date().getTime();

        System.out.println(divide(0, 0));
        System.out.println(divide(4, -2));
        System.out.println(divide(102401, 100));
        System.out.println(divide(5, 2));
        System.out.println(divide(123421384, 2));
        System.out.println(divide(Integer.MAX_VALUE, 2343));
        System.out.println(divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(Integer.MIN_VALUE, 1));
        System.out.println(divide(Integer.MIN_VALUE, Integer.MIN_VALUE));

        long stop = new Date().getTime();
        System.out.println("\nCost Time: " + (stop - start) + "ms");
    }

}
