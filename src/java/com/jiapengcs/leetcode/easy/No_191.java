package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/25
 *
 * 191. Number of 1 Bits
 *
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * 分析：位运算，本题重点在于无符号右移
 */
public class No_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n & 1);
            n >>>= 1;  // 无符号右移
        }
        return ans;
    }

    // 讨论区
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                ans++;
            }
            mask <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_191().hammingWeight(1));
        System.out.println(new No_191().hammingWeight(0x7fffffff));
        System.out.println(new No_191().hammingWeight(0x80000000));
        System.out.println(new No_191().hammingWeight(-1));
    }
}
