package com.jiapengcs.leetcode.easy;

import java.util.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-3
 *
 * 438. Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 *
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * 分析：滑动窗口思想。
 * 用head和tail两个指针构成窗口，
 * tail指针遍历过的位置，该位置字母的计数减一，如果减之前计数大于0，说明这个字母包含在p中，count减一；
 * count值减为0时说明全部匹配，记录head；
 * 当窗口大于p的长度则不可能匹配，head后移同时将该位置字母的计数加一，如果加之前不小于0，说明这个字母包含在p中，count加一。
 */
public class No_438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] buf = new int[26];
        for (int i = 0; i < p.length(); i++) {
            buf[p.charAt(i) - 'a']++;
        }
        int head = 0, tail = 0, count = p.length();
        List<Integer> ans = new ArrayList<>();
        while (tail < s.length()) {
            if (buf[s.charAt(tail++) - 'a']-- > 0) {
                count--;
            }
            if (count == 0) {
                ans.add(head);
            }
            if (tail - head == p.length() && buf[s.charAt(head++) - 'a']++ >= 0) {
                count++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_438().findAnagrams("cbaebabacd", "abc"));
    }
}
