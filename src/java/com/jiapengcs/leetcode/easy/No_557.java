package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/6/23.
 *
 * 557. Reverse Words in a String III
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class No_557 {
    public static String reverseWords(String s) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length;) {
            while (i < str.length && str[i] == ' ') i++;
            int start = i;
            while (i < str.length && str[i] != ' ') i++;
            int end = i - 1;
            reverse(str, start, end);
        }
        return String.valueOf(str);
    }

    private static void reverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }

    //-----------------------------------------------
    // TC: O(n), SC: O(1)
    public static String reverseWords2(String s) {
        String answer = "";
        for (String t : s.split(" "))
            answer = answer.concat(new StringBuffer(t).reverse() + " ");
        return answer.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
