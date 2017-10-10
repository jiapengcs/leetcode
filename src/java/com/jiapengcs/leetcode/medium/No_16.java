package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * Created by Jiapeng 2017/10/10.
 *
 * 16. 3Sum Closest
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * 分析：与15题思路相似。可以不考虑去重。
 */
public class No_16 {
    // TC: O(n^2), SC: O(n)
    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE, answer = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int head = i + 1, tail = nums.length - 1;
            while (head < tail) {
                int sum = nums[i] + nums[head] + nums[tail];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    answer = sum;
                }
                if (sum < target) {
                    head++;
                } else {
                    tail--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, -2, 1, 4}, 1));
        System.out.println(threeSumClosest(new int[]{-1, 2, -1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{-1, 2}, 1));
    }
}
