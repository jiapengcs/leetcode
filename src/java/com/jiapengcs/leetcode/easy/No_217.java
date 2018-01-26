package com.jiapengcs.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/25
 *
 * 217. Contains Duplicate
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * 分析：判断数组是否包含重复元素。
 * 方法一：Hash法，如果往Set重复添加某个元素，add()返回值为false。
 * 方法二：排序，然后查找是否有相邻的元素相等。
 */
public class No_217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null) return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new No_217().containsDuplicate(new int[]{1,2,3,2}));
    }
}
