package com.jiapengcs.leetcode.util;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-5
 *
 * KMP算法实现
 */
public class KMP {

    public int find(String haystack, String pattern) {
        if (haystack.length() < pattern.length()) return -1;
        if (pattern.length() == 0) return 0;
        int[] next = getNext(pattern.toCharArray());
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if (j == pattern.length()) {
                    return i - j;
                }
            } else if (j > 0) {
                j = next[j];
            } else {
                i++;
            }
        }
        return -1;
    }

    private int[] getNext(char[] pattern) {
        //这里的next[0]无效元素，只用next[1]~next[pattern.length]的位置；
        //如果从0开始，因为next[0] = 0，
        //i = 1时，判断pattern[i - 1] == pattern[k]即pattern[i - 1] == pattern[next[i - 1]]时总是成立，造成错误。
        int[] next = new int[pattern.length + 1];
        for (int i = 2; i < next.length; i++) {
            int k = next[i - 1];
            while (k > 0 && pattern[i - 1] != pattern[k]) {
                k = next[k];
            }
            if (k > 0 || pattern[i - 1] == pattern[k]) {
                next[i] = k + 1;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new KMP().find("ababcaababcaabc", "ababcaabc"));
    }
}
