package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/25
 *
 * 268. Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * 分析：找出0, 1, 2, ..., n中缺少的数字。
 * 利用了异或运算的性质：a ^ b = c => a ^ c = b, b ^ c = a.
 */
public class No_268 {
    public int missingNumber(int[] nums) {
        int xor1 = 0, xor2 = 0;
        for (int i = 1; i <= nums.length; i++) {
            xor1 ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            xor2 ^= nums[i];
        }
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        System.out.println(new No_268().missingNumber(new int[]{1,2,0,4}));
    }
}
