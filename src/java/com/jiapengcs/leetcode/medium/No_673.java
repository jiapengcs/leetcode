package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-8
 *
 * 673. Number of Longest Increasing Subsequence
 *
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 *
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1,
 * and there are 5 subsequences' length is 1, so output 5.
 *
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 *
 * 分析：动态规划
 * 用dp[i]表示以第i个元素结尾的最长有序子序列长度，
 * Example 1中，遍历到元素7时，前面部分以每个元素结尾可以形成的最长有序子序列为：
 * 1
 * 1,3
 * 1,3,5
 * 1,3,4
 * 因此以7结尾的最长有序子序列为：
 * 1,3,5,7
 * 1,3,4,7
 * 综上，状态转移方程为：
 * 若nums[i] >= nums[j] && dp[i] < dp[j] + 1, 则dp[i] = dp[j] + 1. (0 <= j < i)
 * dp[i]初始值都为1.
 */
public class No_673 {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];  //记录以当前元素结尾的最长有序子序列长度
        int[] counts = new int[nums.length];  //记录以当前元素结尾的能形成长度为dp[i]的个数
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            counts[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    counts[i] = counts[j];  //第一次形成dp[i]长度
                    max = Math.max(max, dp[i]);
                } else if (nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                    counts[i] += counts[j];  //再次形成dp[i]长度
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_673().findNumberOfLIS(new int[]{1,3,5,4,7}));
        System.out.println(new No_673().findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
}
