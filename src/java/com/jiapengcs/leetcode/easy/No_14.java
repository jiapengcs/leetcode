package com.jiapengcs.leetcode.easy;

import java.util.Arrays;

/**
 * Created by Jiapeng on 2017/9/6.
 *
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * 分析：方法一直接暴力求解；方法二先对字符串排序，这样只需比较前后两个字符串的最长公共前缀。
 */
public class No_14 {
    // TC: O(n^2), SC: O(1)
    public static String longestCommonPrefix1(String[] strs) {
        String answer = "";
        if (strs == null || strs.length == 0) return answer;
        for (int i = 0; i < strs[0].length(); i++) {
            String prefix = strs[0].substring(0, i+1);
            for (String str : strs) {
                if (str.indexOf(prefix) != 0)
                    return answer;
            }
            answer = prefix;
        }
        return answer;
    }

    // TC: O(nlog(n)), SC: O(n)
    public static String longestCommonPrefix2(String[] strs) {
        StringBuilder answer = new StringBuilder();
        if (strs != null && strs.length > 0) {
            Arrays.sort(strs);
            char[] first = strs[0].toCharArray();
            char[] last = strs[strs.length-1].toCharArray();
            for (int i = 0; i < Math.min(first.length, last.length); i++) {
                if (first[i] == last[i]) {
                    answer.append(first[i]);
                } else {
                    break;
                }
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[] {}));
        System.out.println(longestCommonPrefix2(new String[] {"hello", "helloworld", "hell"}));
        System.out.println(longestCommonPrefix2(new String[] {"c", "acc", "ccc"}));
    }
}
