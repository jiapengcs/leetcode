package com.jiapengcs.leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-26
 *
 * 139. Word Break
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings).
 * Please reload the code definition to get the latest changes.
 *
 * 分析：动态规划
 * 假设dp[i]记录i位置之前的字符串是否满足条件，
 * dp[j]为true的条件是：
 * 1. s.substring(i, j)在字典中;
 * 2. dp[i] = true.
 */
public class No_139 {
    // TC: O(n^2), SC: O(n)
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
