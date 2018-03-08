package com.jiapengcs.leetcode.util;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-8
 *
 * 最长公共子序列
 *
 * 分析：动态规划
 * dp[i][j]表示word1的0~i-1位与word2的0~j-1位的最长公共子序列。
 * 1. 当word1[i-1] == word2[j-1], dp[i][j] = dp[i-1][j-1] + 1;
 * 2. 否则dp[i][j] = max(dp[i-1][j], dp[i][j-1]).
 */
public class LongestCommonSequence {
    public int lcs(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSequence().lcs("GCTA", "GBTA"));
        System.out.println(new LongestCommonSequence().lcs("ADE", "ABCDE"));
    }
}
