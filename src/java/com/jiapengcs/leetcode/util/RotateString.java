package com.jiapengcs.leetcode.util;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-15
 * 原理：YX = (XTYT)T (T表示转置)
 */
public class RotateString {
    // k表示左旋k位
    public static String rotate(String str, int k) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int len = str.length();
        k %= len;
        char[] chars = str.toCharArray();
        // eg: str = "abcdefg", k = 3, 将它分为"abc", "defg"两部分，分别逆置得"cbagfed"，最后对整体逆置得"defgabc"
        for (int i = 0, j = k-1; i < j; i++, j--) {
            swap(chars, i, j);
        }
        for (int i = k, j = len-1; i < j; i++, j--) {
            swap(chars, i, j);
        }
        for (int i = 0, j = len-1; i < j; i++, j--) {
            swap(chars, i, j);
        }
        return String.valueOf(chars);
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(rotate("abcdefg", 3));
    }
}
