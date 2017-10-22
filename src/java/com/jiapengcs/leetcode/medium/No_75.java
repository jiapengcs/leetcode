package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * Created by Jiapeng on 2017/10/21.
 *
 * 75. Sort Colors
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * 分析：
 * 方法一：从左往右遍历，如果遇到0，则与低位交换；如果遇到2，则与高位交换。需要注意的是，从高位交换过来的元素，应再次判断是否为0.
 * 方法二：将方法一分为两步，第一次遍历将0全部换到低位，第二次遍历将2全部换到高位。
 * 方法三：第一次遍历记录0, 1, 2的个数，第二次遍历对数组重新赋值。
 */
public class No_75 {
    // TC: O(n), SC: O(1)
    public static void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, p = 0;
        while (p <= high) {
            if (nums[p] == 0) {
                nums[p] = nums[low];
                nums[low++] = 0;
            } else if (nums[p] == 2) {
                nums[p--] = nums[high];  //回退一步抵消下面的p++，判断从后面换过来的元素是否为0
                nums[high--] = 2;
            }
            p++;
        }
    }

    // TC: O(n), SC: O(1)
    public static void sortColors1(int[] nums) {
        int p = 0, q = nums.length - 1;
        while (p < nums.length && nums[p] == 0) p++;
        for (int i = p + 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p];
                nums[p++] = 0;
            }
        }
        while (q >= 0 && nums[q] == 2) q--;
        for (int i = q - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                nums[i] = nums[q];
                nums[q--] = 2;
            }
        }
    }

    // TC: O(n), SC: O(1)
    public static void sortColors2(int[] nums) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) cnt0++;
            if (nums[i] == 1) cnt1++;
            if (nums[i] == 2) cnt2++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cnt0-- > 0) nums[i] = 0;
            else if (cnt1-- > 0) nums[i] = 1;
            else if (cnt2-- > 0) nums[i] = 2;
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 0, 2, 0};
//        int[] nums = new int[]{0, 1};
//        int[] nums = new int[]{0, 2, 0, 0, 0};
//        int[] nums = new int[]{2, 1};
//        int[] nums = new int[]{0, 2, 1};
//        int[] nums = new int[]{0, 1, 0};
        int[] nums = new int[]{0, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
