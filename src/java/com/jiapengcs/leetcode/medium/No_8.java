package com.jiapengcs.leetcode.medium;

/**
 * Created by Jiapeng 2017/10/9.
 *
 * 8. String to Integer (atoi)
 *
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself
 * what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
 * gather all the input requirements up front.
 *
 * 分析：atoi()函数会扫描参数字符串，跳过前面的空白字符（例如空格，tab缩进等），直到遇上数字或正负符号才开始做转换，而在遇到非数字或字符串
 * 结束时('\0')才结束转换，并将结果返回。如果不能转换成int或者为空字符串，那么将返回0；如果转换int越界，则返回INT_MAX(2147483647)
 * 或者INT_MIN(-2147483648)。
 * 1.先用trim()函数除去空白字符;
 * 2.然后判断有无符号;
 * 3.然后开始遍历，遇到非数字字符则结束。
 * 此题容易理解错题意。
 */
public class No_8 {
    // TC: O(n), SC: O(1)
    public static int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) return 0;
        str = str.trim();
        int start = 0;
        boolean isNegative = false;
        if (str.charAt(start) == '+' || str.charAt(start) == '-') {
            isNegative = str.charAt(start++) == '-';
        }
        long ans = 0;
        for (int i = start; i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'; i++) {
            ans = ans * 10 + str.charAt(i) - '0';
            if (ans > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        ans = isNegative ? -ans : ans;
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   "));
        System.out.println(myAtoi("     -123a"));
        System.out.println(myAtoi("123.45"));
        System.out.println(myAtoi("+123"));
        System.out.println(myAtoi("-+1"));
        System.out.println(myAtoi("+-2"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi(null));
        System.out.println(myAtoi(" b11228552307"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("9223372036854775809"));
        System.out.println(myAtoi("-1234567890123456789012345678901234567890"));
    }
}
