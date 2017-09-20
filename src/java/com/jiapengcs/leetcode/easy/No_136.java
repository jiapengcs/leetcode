package com.jiapengcs.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jiapeng on 2017/9/17.
 *
 * 136. Single Number
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * 分析：给定一个整数数组，只有一个数出现一次，其余所有数都出现两次。找出这个落单的数。
 * 方法一：按位异或，两个相同的数会相互抵消成为0.
 * 方法二：Hash表记录每个数出现的次数。
 * 方法三：遍历将数加入集合，计算：所有数的累加 - 2 * 集合的累加和。
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

    // TC: O(n), SC: O(n)
    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);
        for (int k : map.keySet())
            if (map.get(k) == 1) return k;
        return 0;
    }

    // TC: O(n), SC: O(n)
    public static int singleNumber3(int[] nums) {
        int sum = 0, tmp = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            sum += x;
            set.add(x);
        }
        for (int y : set) tmp += y;
        return sum - 2 * tmp;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber3(new int[] {1, 1, 2, 3, 3}));
    }
}
