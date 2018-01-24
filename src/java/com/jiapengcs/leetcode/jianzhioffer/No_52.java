package com.jiapengcs.leetcode.jianzhioffer;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-22
 *
 * 52.正则表达式匹配
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配。
 *
 * 分析： 先看代码和注释
 * 链接：https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
 * 来源：牛客网
 * 思路：只有当模式串和字符串同时等于\0，才可以认为两个串匹配。
 * 在匹配中，对于每个位的匹配可以分为三种情况
 * 1、（相应位匹配||模式串为.&&字符串不是\0）&&模式串下一位是*
 * 2、（相应位匹配||模式串为.&&字符串不是\0）&&模式串下一位不是*
 * 3、相应位不匹配&&（模式位不为.||字符串是\0）
 * 对应1，最复杂。分为*取0，*取1，*>=2三种情况。
 * 取0对应跳过当前匹配位，继续寻找patter的下一个匹配位，str不变，pattern+2
 * 取1对应当前匹配位算一次成功匹配，str+1，pattern+2
 * 取>=2对应一次成功匹配，继续匹配字符串的下一位是否匹配，str+1，pattern不变
 * 三者取或。即只要有一种情况能匹配成功认为字符串就是匹配成功的。
 * 对应2，相当于一次成功匹配，str+1，pattern+1
 * 对应3，匹配失败，直接返回false
 */
public class No_52 {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }

    private boolean matchCore(char[] str, char[] pattern, int sIndex, int pIndex) {
        if (sIndex == str.length && pIndex == pattern.length) {
            return true;
        }
        if (sIndex != str.length && pIndex == pattern.length) {
            return false;
        }
        // pattern下一位是"*"
        if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*') {
            // 当前位匹配，"*"可以取1，也可以取0(跳过)
            if (sIndex < str.length && (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.')) {
                return matchCore(str, pattern, sIndex+1, pIndex) || matchCore(str, pattern, sIndex, pIndex+2);
            } else {  // 当前位不匹配，"*"必须取0(跳过)
                return matchCore(str, pattern, sIndex, pIndex+2);
            }
        }
        // pattern下一位不是"*"
        if (sIndex < str.length && (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.')) {
            return matchCore(str, pattern, sIndex+1, pIndex+1);
        }
        return false;
    }

    public static void main(String[] args) {
        No_52 no_52 = new No_52();
        System.out.println(no_52.match(new char[]{'a', 'a', 'a'}, new char[]{'a', '.', 'a'}));
        System.out.println(no_52.match(new char[]{'a', 'a', 'a'}, new char[]{'a', '*', 'a'}));
        System.out.println(no_52.match(new char[]{'a', 'a', 'a'}, new char[]{'a', 'b', '*', 'a', 'c', '*', 'a'}));
        System.out.println(no_52.match(new char[]{'a', 'a', 'a'}, new char[]{'a', 'a', '.', 'a'}));
        System.out.println(no_52.match(new char[]{'a', 'a', 'a'}, new char[]{'a', 'b', '*', 'a'}));
        System.out.println(no_52.match(new char[]{'a', 'a', 'b'}, new char[]{'a', 'a', '*', 'b'}));
        System.out.println(no_52.match(new char[]{}, new char[]{'.', '*', '.', '*'}));
    }
}
