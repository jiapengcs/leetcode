package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng 2017/9/27.
 *
 * 122. Best Time to Buy and Sell Stock II
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
 * transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * 分析：不限制交易次数，求最大收益。遇到上涨的情况（即某日比前一日价格高）则进行一次买入卖出，将每次的收益累加。
 */
public class No_122 {
    // TC: O(n), SC: O(1)
    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[] {7, 6, 4, 3, 2, 1}));
    }
}
