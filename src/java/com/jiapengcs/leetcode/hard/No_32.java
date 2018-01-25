package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/25
 *
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 * 分析：
 * 方法一：动态规划，遇到左括号dp值为0，右括号则记录当前最长有效括号，分......()和......))两种情况
 * 1) eg: "(()" or "()()" => dp[i] = dp[i-2] + 2
 * 2) eg:
 *      "()(())" => s.charAt(i - dp[i-1] - 1) == '(' => dp[i] = dp[i - dp[i-1] - 2] + dp[i-1] + 2;（前面有左括号与当前右括号匹配）
 *      "())())" => s.charAt(i - dp[i-1] - 1) == ')' => dp[i] = 0;（前面没有左括号与当前右括号匹配）
 * 方法二：从左往右遍历，用left, right分别统计左右括号的个数，任何时候：
 *      （1）如果left == right，此时匹配，记录长度；
 *      （2）如果left < right，则不可能匹配，将left, right重置为0，继续遍历。
 *      然后从右往左遍历，与上述步骤类似，记录两次遍历出现的最大长度。
 *      *遍历两次的原因是避免遗漏的情况，如"((())"，从左往右结果为0（right一直小于left），从右往左结果为2.
 */
public class No_32 {
    // TC: O(n), SC: O(n)
    public int longestValidParentheses1(String s) {
        if (s == null) return 0;
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = i < 2 ? 2 : dp[i-2] + 2;
                } else if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                    int pre = (i - dp[i-1] - 2) < 0 ? 0 : dp[i - dp[i-1] - 2];
                    dp[i] = pre + dp[i-1] + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    // TC: O(n), SC: O(1)
    public int longestValidParentheses2(String s) {
        if (s == null) return 0;
        int ans = 0, left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, left);
            } else if (left < right) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return 2 * ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_32().longestValidParentheses1("())"));
    }
}
