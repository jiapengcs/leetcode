package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng 2017/9/27.
 *
 * 121. Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 *
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 *
 * 分析：交易次数限制为一次买入卖出，求最大收益。
 * 方法一：暴力法，依次选定买入的价格，向后遍历找到收益最大的卖出价格。（超时）
 * 方法二：依次遍历，将当前遇到的最低价格作为为买入价格，计算后续作为卖出价格的收益，记录出现的最大值。
 */
public class No_121 {
    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            int max = 0;
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static int maxProfit2(int[] prices) {
        int ans = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[] {7, 6, 4, 3, 2, 1}));
    }
}
