package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Jiapeng 2017/10/10.
 *
 * 17. Letter Combinations of a Phone Number
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 分析：结果集随着输入的增加呈指数级增长，排除暴力法。
 * 考虑到后一次迭代在前一次结果基础上增加一个字符，采用队列来保存当前的结果集，每次迭代长度增长一位。
 * 下列两种方法复杂度一致，但方法二直接将LinkedList用作队列，可以简化代码。
 */
public class No_17 {
    // TC: O(n^4), SC: O((3~4)^n)
    public static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits == null || digits.length() == 0 || digits.contains("0") || digits.contains("1")) return answer;
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            int size = queue.size();
            while (size-- > 0) {
                String str = queue.poll();
                char[] buf = mapping[digit].toCharArray();
                for (char c : buf) {
                    queue.add(str + c);
                }
            }
        }
        while (!queue.isEmpty()) {
            answer.add(queue.poll());
        }
        return answer;
    }

    // TC: O(n^4), SC: O((3~4)^n)
    public static List<String> letterCombinations2(String digits) {
        LinkedList<String> answer = new LinkedList<>();
        if (digits == null || digits.length() == 0 || digits.contains("0") || digits.contains("1")) return answer;
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        answer.add("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            while (answer.peek().length() == i) {
                String str = answer.poll();
                char[] buf = mapping[digit].toCharArray();
                for (char c : buf) {
                    answer.add(str + c);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("234"));
        System.out.println(letterCombinations("2345"));
        System.out.println(letterCombinations(""));
    }
}
