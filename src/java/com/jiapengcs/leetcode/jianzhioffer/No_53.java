package com.jiapengcs.leetcode.jianzhioffer;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-22
 *
 * 53.表示数值的字符串
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 分析：借助自动机实现
 */
public class No_53 {
    public boolean isNumeric(char[] str) {
        int len = str.length, i = 0;
        if (str[i] == '+' || str[i] == '-' || isDigit(str[i])) {
            while (++i < len && isDigit(str[i]));
            if (i == len) {
                return true;
            } else if (str[i] == '.') {
                if (i + 1 == len) {
                    return true;
                }
                while (++i < len && isDigit(str[i]));
                if (i == len) {
                    return true;
                }
                if (str[i] == 'e' || str[i] == 'E') {
                    if (++i < len && (str[i] == '+' || str[i] == '-' || isDigit(str[i]))) {
                        while (++i < len && isDigit(str[i]));
                        if (i == len) {
                            return true;
                        }
                    }
                }
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (++i < len && (str[i] == '+' || str[i] == '-' || isDigit(str[i]))) {
                    while (++i < len && isDigit(str[i]));
                    if (i == len) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        System.out.println(new No_53().isNumeric(new char[]{'+', '1', '0', '0'}));
        System.out.println(new No_53().isNumeric(new char[]{'5', 'e', '2'}));
        System.out.println(new No_53().isNumeric(new char[]{'-', '1', '2', '3'}));
        System.out.println(new No_53().isNumeric(new char[]{'3', '.', '1', '4', '1', '6'}));
        System.out.println(new No_53().isNumeric(new char[]{'-', '1', 'E', '-', '1', '6'}));
        System.out.println(new No_53().isNumeric(new char[]{'1', '2', 'e'}));
        System.out.println(new No_53().isNumeric(new char[]{'1', 'a', '3', '.', '1', '4'}));
        System.out.println(new No_53().isNumeric(new char[]{'1', '.', '2', '.', '3'}));
        System.out.println(new No_53().isNumeric(new char[]{'+', '-', '5'}));
        System.out.println(new No_53().isNumeric(new char[]{'1', '2', 'e', '+', '4', '.', '3'}));

        System.out.println(new No_53().isNumeric(new char[]{'+'}));
        System.out.println(new No_53().isNumeric(new char[]{'1', 'e', '+'}));
        System.out.println(new No_53().isNumeric(new char[]{'1', '2', '3', '.', '4', '5', 'e', '+', '6'}));
    }
}
