package com.jiapengcs.leetcode.easy;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-11
 *
 * 28. Implement strStr()
 *
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * 分析：字符串查找
 * 方法一：暴力法，复杂度为O(m * n)
 * 方法二：KMP算法，复杂度为O(m + n)
 */
public class No_28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        int len = needle.length();
        for (int i = 0, j = len; j <= haystack.length(); i++, j++) {
            if (needle.equals(haystack.substring(i, j))) {
                return i;
            }
        }
        return -1;
    }

    // KMP算法实现见util.KMP.java
}
