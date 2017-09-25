package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/9/7.
 *
 * 58. Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example,
 * Given s = "Hello World", return 5.
 *
 * 分析：由用例，先去掉末尾的空格
 */
public class No_58 {
    // TC: O(n), SC: O(1)
    public static int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0, index = s.length() - 1;
        while (index >= 0 && s.charAt(index--) == ' ');  //find last character which isn't space
        for (index++; index >= 0 && s.charAt(index) != ' '; index--)
            count++;
        return count;
    }

    // TC: O(n), SC: O(1)
    public static int lengthOfLastWord2(String s) {
        return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2(""));
        System.out.println(lengthOfLastWord2("      "));
        System.out.println(lengthOfLastWord2("a ddd  "));
    }
}
