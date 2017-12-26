package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/20
 *
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 */
public class No_151 {
    // TC: O(n), SC: O(n)
    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String answer = "";
        String[] strs = s.split(" ");
        for (String str : strs) {
            if (!str.equals(" ") && !str.equals("")) {
                answer = str + " " + answer;
            }
        }
        return answer.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" the  sky            is blue "));
        System.out.println(reverseWords(null));
    }
}
