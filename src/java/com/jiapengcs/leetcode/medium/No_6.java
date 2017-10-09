package com.jiapengcs.leetcode.medium;

/**
 * Created by Jiapeng 2017/10/9.
 *
 * 6. ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * 分析：题意为将字符串按Z字形排列，然后按行拼接输出。
 * eg(nRows = 4):
 * P        I        N
 * A     L  S     I  G
 * Y  A     H  R
 * P        I
 * 创建StringBuilder数组，将字符串按照垂直、水平方向插入，最后拼接输出
 */
public class No_6 {
    // TC: O(n), SC: O(n)
    public static String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++) {
                sb[i].append(s.charAt(index++));
            }
            for (int i = numRows - 2; i >= 1 && index < s.length(); i--) {
                sb[i].append(s.charAt(index++));
            }
        }
        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("PAYPALISHIRING", 1));
    }
}
