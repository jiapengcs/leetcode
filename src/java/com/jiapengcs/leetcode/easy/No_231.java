package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-26
 *
 * 231. Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * 分析：判断一个数是否2的幂。
 */
public class No_231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
