package com.jiapengcs.leetcode.medium;

/**
 * Created by Jiapeng 2017/10/24.
 *
 * 80. Remove Duplicates from Sorted Array II
 *
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 *
 * 分析：26题的变种。
 * 遇到重复元素时，只需判断前面是否已经出现两次。
 */
public class No_80 {
    // TC: O(n), SC: O(1)
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[answer] || answer == 0 || nums[answer] != nums[answer-1]) {
                nums[++answer] = nums[i];
            }
        }
        return ++answer;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 3, 3, 3, 4, 4}));
    }
}
