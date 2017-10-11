package com.jiapengcs.leetcode.medium;

import java.util.*;

/**
 * Created by Jiapeng 2017/10/11.
 *
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 分析：回溯法，当左括号数小于总对数时，增加左括号；否则，当右括号数小于左括号数时，增加右括号。
 * 这样保证了当左右括号数等于总对数*2时，所有的括号总是闭合的。
 */
public class No_22 {
    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtrack("", 0, 0, n, answer);
        return answer;
    }

    public static void backtrack(String str, int left, int right, int n, List<String> result) {
        if (str.length() == n * 2) {
            result.add(str);
            return;
        }
        if (left < n) {
            backtrack(str + "(", left + 1, right, n, result);
        }
        if (right < left) {
            backtrack(str + ")", left, right + 1, n, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(0));
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
        System.out.println(generateParenthesis(5));
    }
}
