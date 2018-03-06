package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-11
 *
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain
 * all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class No_76 {
    public String minWindow(String s, String t) {
        String ans = "";
        if (s == null || t == null) {
            return ans;
        }
        int[] buf = new int[128];
        for (int i = 0; i < t.length(); i++) {
            buf[t.charAt(i)]++;
        }
        int head = 0, tail = 0, count = t.length();
        while (tail < s.length()) {
            if (buf[s.charAt(tail++)]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (ans.length() == 0 || tail - head < ans.length()) {
                    ans = s.substring(head, tail);
                }
                if (buf[s.charAt(head++)]++ == 0) {
                    count++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
