package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-14
 *
 * 43. Multiply Strings
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 *
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * 分析：大数乘法
 * 两数相乘，总位数不超过两数的位数之和。
 * 每两个数字相乘，积的位置是确定的，从左往右，
 * 被乘数第1位的9与乘数第1位的8相乘，积为72，位置为第2位和第3位；
 * 被乘数第0位的9与乘数第1位的8相乘，积为72，位置为第1位和第2位；
 * 被乘数第1位的9与乘数第0位的9相乘，积为81，位置为第1位和第2位；
 * 被乘数第0位的9与乘数第0位的9相乘，积为81，位置为第0位和第1位；
 * 即被乘数第i位与乘数第j位相乘的积，占据的位置分别为第(i + j)位和第(i + j + 1)位。
 * 例如99 × 98：
 *     9 9
 *   x 9 8
 * -------
 *     7 2
 *   7 2
 *   8 1
 * 8 1
 * -------
 * 9 7 0 2
 * 用一个大小为(m + n)的数组来记录积的各个位置上的数字，从乘数的个位开始乘以被乘数，同时更新这个数组，
 * 最后将数组拼接成积的字符串。
 */
public class No_43 {
    // TC: O(m*n), SC: O(1)
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] buf = new int[m+n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n -1; j >= 0; j--) {
                int x = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = x + buf[p2];
                buf[p1] += sum / 10;
                buf[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int b : buf) {
            if (!(sb.length() == 0 && b == 0)) {
                sb.append(b);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123529345920384751934712348129123529345920384712352934592038475193471234812912352934592038475193471234812951934712348129", "112352934592038475193471234812912352934592038475193471234812923529345920384751934712348129123529345920384751934712348129"));
    }
}
