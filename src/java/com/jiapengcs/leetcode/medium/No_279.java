package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-24
 *
 * 279. Perfect Squares
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *
 * 分析：动态规划，后面的状态可以由前面的状态组成
 */
public class No_279 {
    // TC: O(n^2), SC: O(n)
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int root = (int) Math.sqrt(i);
            if (root * root == i) {
                dp[i] = 1;
                continue;
            }
            int start = 1, end = i - 1;
            dp[i] = 0x7fffffff;
            for (; start <= end; start++, end--) {
                dp[i] = Math.min(dp[i], dp[start] + dp[end]);
            }
        }
        return dp[n];
    }

    /* 讨论区答案
    dp[0] = 0
    dp[1] = dp[0]+1 = 1
    dp[2] = dp[1]+1 = 2
    dp[3] = dp[2]+1 = 3
    dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
          = Min{ dp[3]+1, dp[0]+1 }
          = 1
    dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
          = Min{ dp[4]+1, dp[1]+1 }
          = 2
    dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
           = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
           = 2
    dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     */
    // TC: O(nlogn), SC: O(n)
    public int numSquares2(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = 0x7fffffff;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new No_279().numSquares2(13));
    }
}
