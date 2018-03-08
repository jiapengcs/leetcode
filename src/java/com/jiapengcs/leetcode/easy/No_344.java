package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-8
 *
 * 344. Reverse String
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 */
public class No_344 {
    public String reverseString(String s) {
        char[] buf = s.toCharArray();
        for (int i = 0, j = buf.length-1; i < j; i++, j--) {
            char tmp = buf[i];
            buf[i] = buf[j];
            buf[j] = tmp;
        }
        return String.valueOf(buf);
    }
}
