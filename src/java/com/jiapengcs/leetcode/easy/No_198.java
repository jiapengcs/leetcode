package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/25
 *
 * 198. House Robber
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * 分析：题意为在正数数组中找不相邻的元素和的最大值。
 * 方法一：动态规划
 *      i < 2: dp[i] = nums[i];
 *      i == 3: dp[i] = dp[i-2] + nums[i];
 *      i > 3: dp[i] = max(dp[i-2], dp[i-3]) + nums[i];
 * 方法二：用a, b交替保存第i-2和第i-1个位置的最大和，假设到达位置i时，..., a, b, nums[i], ...
 *      b与i相邻，a与i不相邻，因此要么取b，要么取a+num[i]，将较大的赋值给a。
 *      继续往后遍历：..., b, a, nums[i+1], ...
 */
public class No_198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < 2) {
                dp[i] = nums[i];
            } else if (i < 3) {
                dp[i] = dp[i-2] + nums[i];
            } else {
                dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
            }
        }
        int ans = 0;
        for (int d : dp) {
            ans = Math.max(ans, d);
        }
        return ans;
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                a = Math.max(b, a + nums[i]);
            } else {
                b = Math.max(a, b + nums[i]);
            }
        }
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        System.out.println(new No_198().rob(new int[]{10, 8, 3, 9, 9, 6}));
        System.out.println(new No_198().rob(new int[]{10, 8, 3, 9, 9, 6, 10}));
    }
}
