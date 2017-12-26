package com.jiapengcs.leetcode.medium;

import java.util.Stack;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-26
 *
 * 150. Evaluate Reverse Polish Notation
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * 分析：逆波兰式
 * 遇到操作数入栈，遇到操作符弹出栈顶的两个元素，计算后入栈，最后栈中剩下的数为结果。
 */
public class No_150 {
    // TC: O(n), SC: O(n)
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                switch (str) {
                    case "+": stack.push(b + a); break;
                    case "-": stack.push(b - a); break;
                    case "*": stack.push(b * a); break;
                    case "/": stack.push(b / a); break;
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
