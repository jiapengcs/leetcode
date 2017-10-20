package com.jiapengcs.leetcode.medium;

/**
 * Created by Jiapeng 2017/10/20.
 *
 * 55. Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 * 分析：Assume that we can move step = nums[0] steps at the beginning, then move to num[1] and step--,
 * always take the max of num[1] and step as remaining steps, repeat until arriving at the last element.
 * If step == 0 during the iteration, it means we couldn't move any more neither reach the end, so return false.
 */
public class No_55 {
    // TC: O(n), SC: O(1)
    public static boolean canJump(int[] nums) {
        int step = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (step == 0) return false;
            step = Math.max(--step, nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{3, 5, 1, 0, 4}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{0, 1}));
    }
}
