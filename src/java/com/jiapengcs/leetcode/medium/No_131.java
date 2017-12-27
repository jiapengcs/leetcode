package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-27
 *
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 *
 * 分析：回溯法
 * 发现：将递归函数能独立的部分写成独立的函数，可以提高执行效率。
 */
public class No_131 {

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtracking(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void backtracking(String s, int start, List<String> buf, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(buf));
        }
        for (int i = start+1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                buf.add(str);
                backtracking(s, i, buf, ans);
                buf.remove(buf.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String str) {
        for (int m = 0; m < str.length() / 2; m++) {
            if (str.charAt(m) != str.charAt(str.length() - m - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
