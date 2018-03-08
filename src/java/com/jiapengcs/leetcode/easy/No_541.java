package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-8
 *
 * 541. Reverse String II
 *
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters
 * counting from the start of the string. If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters
 * and left the other as original.
 *
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class No_541 {
    public String reverseStr(String s, int k) {
        char[] buf = s.toCharArray();
        int i = 0;
        for (; i + k <= s.length(); i += 2 * k) {
            reverse(buf, i, i+k-1);
        }
        if (i + k > s.length()) {
            reverse(buf, i, buf.length-1);
        }
        return String.valueOf(buf);
    }

    public void reverse(char[] buf, int start, int end) {
        for (int m = start, n = end; m < n; m++, n--) {
            char tmp = buf[m];
            buf[m] = buf[n];
            buf[n] = tmp;
        }
    }
}
