package com.jiapengcs.leetcode.easy;

import java.util.Arrays;

/**
 * Created by Jiapeng on 2017/7/11.
 *
 * 66. Plus One
 *
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * 思路：
 *  给定一个以非空数组表示的非负整数，对这个整数加一
 */
public class No_66 {
    // TC: O(n), SC: O(n)
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i --) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0)
                return digits;  //没有进位，直接返回
        }
        int[] tmp = new int[digits.length + 1];  //最高位进位，数组长度加一，最高位置为1，其他位为默认值0
        tmp[0] = 1;
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 8})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
    }
}
