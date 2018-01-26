package com.jiapengcs.leetcode.easy;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/25
 *
 * 283. Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
 * the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 *
 * 分析：双指针，一个指针p0指向开头，另一个指针p从头向后遍历，遇到非零元素则跟p0位置交换，p0后移。
 */
public class No_283 {
    // 类似冒泡排序
    public void moveZeroes1(int[] nums) {
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length && nums[j] != 0; j++) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    // 双指针
    public void moveZeroes2(int[] nums) {
        for (int p0 = 0, p = 0; p < nums.length; p++) {
            if (nums[p] != 0) {
                int tmp = nums[p0];
                nums[p0++] = nums[p];
                nums[p] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new No_283().moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
