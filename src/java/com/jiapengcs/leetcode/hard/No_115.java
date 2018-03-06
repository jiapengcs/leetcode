package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 115. Distinct Subsequences
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 *
 * 分析：求字符串S中包含多少个子序列T。
 * dp[i][j]：表示S的0～i-1位子串包含dp[i][j]个T的0～j-1位的子序列。
 * dp[0][0] = 1: 表示S为空，T为空，S包含1个T。
 * if s.charAt(i - 1) == t.charAt(j - 1) : dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
 * else : dp[i][j] = dp[i - 1][j]
 * 解释：
 * 1. 当s.charAt(i - 1)不等于t.charAt(j - 1)，这种情况很简单，dp值与s取前一位一致，即dp[i][j] = dp[i - 1][j];
 * 2. 当s.charAt(i - 1)等于t.charAt(j - 1)，我们可以分两种情况：
 * 不匹配s.charAt(i - 1)和t.charAt(j - 1)时，即dp[i][j] = dp[i - 1][j];
 * 匹配s.charAt(i - 1)和t.charAt(j - 1)时，即dp[i][j] = dp[i - 1][j - 1];
 * 综合两种情况：dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]。
 */
public class No_115 {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {  //T为空时，S包含1个T
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n && j <= i; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new No_115().numDistinct("rabbbit", "rabbit"));
    }
}
