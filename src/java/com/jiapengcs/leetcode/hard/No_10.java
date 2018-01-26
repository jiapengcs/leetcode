package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-25
 *
 * 分析：见52.正则表达式匹配
 */
public class No_10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return matchCore(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean matchCore(char[] s, char[] p, int sIndex, int pIndex) {
        if (sIndex == s.length && pIndex == p.length) {
            return true;
        }
        // pattern下一位是"*"
        if (pIndex + 1 < p.length && p[pIndex + 1] == '*') {
            // 当前位匹配，"*"可以取1，也可以取0(跳过)
            if (sIndex < s.length && (s[sIndex] == p[pIndex] || p[pIndex] == '.')) {
                return matchCore(s, p, sIndex + 1, pIndex) || matchCore(s, p, sIndex, pIndex + 2);
            } else {  // 当前位不匹配，"*"必须取0(跳过)
                return matchCore(s, p, sIndex, pIndex + 2);
            }
        }
        // pattern下一位不是"*"
        if (sIndex < s.length && pIndex < p.length && (s[sIndex] == p[pIndex] || p[pIndex] == '.')) {
            return matchCore(s, p, sIndex + 1, pIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new No_10().isMatch("aaa", "a*."));
    }
}
