package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/9/7.
 *
 * 67. Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *
 * 分析：两个数的末位与进位相加，然后向前进位。重复直到两个数的最高位。
 * tips: 1.对字符表示的数字的计算可以减去0的字符表示，例如'1'加'2'的算术值等于'1' + '2' - 2 * '0' = 3.
 *       2.操作String串中特定位置的字符可以使用charAt()方法。
 */
public class No_67 {
    // TC: O(max(m,n)), SC: O(max(m,n))
    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, tmp = 0;
        while (i >= 0 || j >= 0){
            if (i >= 0) {
                tmp += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                tmp += b.charAt(j--) - '0';
            }
            builder.append(tmp & 1);
            tmp >>= 1;
        }
        if (tmp == 1) builder.append(tmp);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("0", "0"));
    }
}
