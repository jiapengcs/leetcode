package com.jiapengcs.leetcode.medium;

/**
 * Created by Jiapeng on 2017/10/9.
 *
 * 5. Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 *
 * 分析：给定一个字符串，找出最长的回文子串。
 * 方法一：暴力法，对两两位置间的子串进行判断。
 * 方法二：依次对每一个或两个字符，向两边扩散，找出最长的回文子串。
 * 方法三：动态规划，如果s(i) == s(j)且p(i+1, j-1)为回文，则p(i, j)为回文。特殊情况：s(i) == s(j)且p(i, j)长度为1或2时也是回文。
 */
public class No_5 {
    // TC: O(n^3), SC: O(1)
    public static String longestPalindrome1(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                boolean isPalindrome = true;
                for (int head = i, tail = j; head < tail; head++, tail--) {
                    if (s.charAt(head) != s.charAt(tail)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome && (j - i > end - start)) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    // TC: O(n^2), SC: O(1)
    public static String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > end - start + 1) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


     // TC: O(n^2), SC: O(n^2)
    public static String longestPalindrome(String s) {
        int start = 0, end = 0, len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("wqeabacdefdcaba"));
        System.out.println(longestPalindrome("abbd"));
        System.out.println(longestPalindrome("a"));
    }
}
