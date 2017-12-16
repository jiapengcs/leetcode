package com.jiapengcs.leetcode.medium;

import java.util.Stack;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/16
 *
 * 71. Simplify Path
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 *
 * 分析：
 * 首先按"/"分割字符串，用栈保存遍历到的路径名，遇到路径名则入栈，遇到".."则出栈，最后将栈中内容拼接成完整路径。
 */
public class No_71 {
    // TC: O(n), SC: O(n)
    public static String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (!dir.equals("") && !dir.equals(".")) {
                stack.push(dir);
            }
        }
        String answer = "";
        for (String dir : stack) {
            answer += "/" + dir;
        }
        return answer.equals("") ? "/" : answer;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
    }
}
