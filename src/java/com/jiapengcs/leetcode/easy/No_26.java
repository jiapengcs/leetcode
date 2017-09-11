package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/7/10.
 *
 * 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't
 * matter what you leave beyond the new length.
 *
 * 思路:
 *  此题的意思不仅仅是返回新的数组长度，还应将去重后的元素写到数组头部。
 */
public class No_26 {
    // TC: O(n), SC: O(1)
    public static int removeDuplicates(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[ans] != nums[i]) {
                nums[++ans] = nums[i];
            }
        }
        return ++ans;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }
}
