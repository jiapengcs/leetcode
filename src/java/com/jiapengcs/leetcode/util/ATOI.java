package com.jiapengcs.leetcode.util;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-5
 *
 * 实现atoi()函数
 *
 * 分析：atoi()函数会扫描参数字符串，跳过前面的空白字符（例如空格，tab缩进等），直到遇上数字或正负符号才开始做转换，而在遇到非数字或字符串
 * 结束时('\0')才结束转换，并将结果返回。如果不能转换成int或者为空字符串，那么将返回0；如果转换int越界，则返回INT_MAX(2147483647)
 * 或者INT_MIN(-2147483648)。
 * 1. 判断trim()字符串是否为空；
 * 2. trim()除去空白字符；
 * 3. 判断符号位；
 * 4. 遍历直到末尾或者遇到非数字字符。
 */
public class ATOI {

    public int atoi(String str) {
        if (str == null || str.trim().length() == 0) return 0;
        str = str.trim();
        int idx = 0;
        boolean isNegative = false;
        if (str.charAt(idx) == '+' || str.charAt(idx) == '-') {
            isNegative = (str.charAt(idx++) == '-');
        }
        long ans = 0;
        while (idx < str.length()) {
            char ch = str.charAt(idx++);
            if (ch < '0' || ch > '9') break;
            ans = ans * 10 + ch - '0';
            if (!isNegative && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (isNegative && -ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        ans = isNegative ? -ans : ans;
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new ATOI().atoi("   "));
        System.out.println(new ATOI().atoi("     -123a"));
        System.out.println(new ATOI().atoi("123.45"));
        System.out.println(new ATOI().atoi("123 45"));
        System.out.println(new ATOI().atoi("+123"));
        System.out.println(new ATOI().atoi("-+1"));
        System.out.println(new ATOI().atoi("+-2"));
        System.out.println(new ATOI().atoi(""));
        System.out.println(new ATOI().atoi(null));
        System.out.println(new ATOI().atoi(" b11228552307"));
        System.out.println(new ATOI().atoi("2147483648"));
        System.out.println(new ATOI().atoi("9223372036854775809"));
        System.out.println(new ATOI().atoi("-1234567890123456789012345678901234567890"));
    }
}
