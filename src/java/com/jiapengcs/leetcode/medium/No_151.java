package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/20
 */
public class No_151 {
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
