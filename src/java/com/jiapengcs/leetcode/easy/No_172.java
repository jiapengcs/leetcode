package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 172. Factorial Trailing Zeroes
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * 分析：求n!有多少个后缀0.
 * 因为n!中包含偶数，因此每出现因子5都能增加一个0，问题转化为求1～n中因子5的个数。
 */
public class No_172 {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}
