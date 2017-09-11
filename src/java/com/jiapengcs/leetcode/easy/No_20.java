package com.jiapengcs.leetcode.easy;

import java.util.Stack;

/**
 * Created by Jiapeng on 2017/9/6.
 *
 * 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * 分析：遇到左括号入栈，遇到右括号则弹出栈顶元素，检查是否匹配。
 */
public class No_20 {
    // TC: O(n), SC: O(n)
    public static boolean isValid(String s) {
        char[] buf = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : buf) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.empty() || (c == ')' && stack.pop() != '(') || (c == ']' && stack.pop() != '[') || (c == '}' && stack.pop() != '{')) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()(){}"));
        System.out.println(isValid("())({}"));
        System.out.println(isValid(")(){}"));
        System.out.println(isValid("()(){"));
        System.out.println(isValid(""));
    }
}
