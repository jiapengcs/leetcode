package com.jiapengcs.leetcode.easy;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-4
 *
 * 242. Valid Anagram
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * 分析：
 * 方法一：Hash计数
 * 方法二：排序
 */
public class No_242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] buf = new int[26];
        for (int i = 0; i < s.length(); i++) {
            buf[s.charAt(i) - 'a']++;
            buf[t.charAt(i) - 'a']--;
        }
        for (int num : buf) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        s = new String(sChars);
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        t = new String(tChars);
        return s.equals(t);
    }
}
