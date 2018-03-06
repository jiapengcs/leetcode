package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-26
 *
 * 326. Power of Three
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 * 分析：判断一个数是否4的幂。
 * 利用对数变换直接计算对数是否为整数。log3(n) = log10(n) / log10(3)
 */
public class No_326 {
    public boolean isPowerOfThree(int n) {
        double log = Math.log10(n) / Math.log10(3);
        return log == (int) log;
    }
}
