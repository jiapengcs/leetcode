package com.jiapengcs.leetcode.medium;

/**
 * Created by Jiapeng 2017/10/9.
 *
 * 12. Integer to Roman
 *
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * 分析：将数字转换为罗马数字。
 * 参考答案。此类题目应考虑列举法。
 */
public class No_12 {
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(99));
        System.out.println(intToRoman(499));
        System.out.println(intToRoman(3999));
        System.out.println(intToRoman(1234));
        System.out.println(intToRoman(2468));
    }
}
