package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/9/17.
 *
 * 136. Single Number
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * 分析：按位异或，两个相同的数会相互抵消成为0.
 */
public class No_136 {
    // TC: O(n), SC: O(1)
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {1, 1, 2, 3, 3}));
    }
}
