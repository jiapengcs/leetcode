package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/25
 *
 * 190. Reverse Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * Follow up:
 * If this function is called many times, how would you optimize it?
 *
 * 分析：位运算，注意无符号右移
 */
public class No_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_190().reverseBits(43261596));
        System.out.println(new No_190().reverseBits(-1));
        System.out.println(new No_190().reverseBits(0x80000000));
    }
}
