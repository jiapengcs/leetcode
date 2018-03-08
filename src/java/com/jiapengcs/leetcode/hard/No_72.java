package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-8
 *
 * 72. Edit Distance
 *
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 * 分析：动态规划
 * dp[i][j]表示word1的0~i-1位与word2的0~j-1位的Edit Distance；
 * dp[i][0]和d[0][j]表示其中一个字符串为空，此时对应的Edit Distance应该为i和j；
 * 1. 当word1[i-1] == word2[j-1]时，当前位不用修改，dp[i][j] = dp[i-1][j-1]；
 * 2. 否则比较分别进行插入、删除、替换操作，形成的Edit Distance，取最小的那个，
 *    即dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1.
 */
public class No_72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int j = 0; j <= len2; j++) dp[0][j] = j;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(new No_72().minDistance("", "a"));
        System.out.println(new No_72().minDistance("sea", "att"));
    }
}
