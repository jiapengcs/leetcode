package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-26
 *
 * 152. Maximum Product Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 * 分析：动态规划
 * 记录最大乘积max和最小乘积min，如果最后一个元素x为正，则结果为max*x, 否则结果为min*x。
 */
public class No_152 {
    // TC: O(n), SC: O(1)
    public static int maxProduct(int[] nums) {
        int ans = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                max += min;
                min = max - min;
                max -= min;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-1, 2, -3, 2, -4}));
        System.out.println(maxProduct(new int[]{1}));
    }
}
