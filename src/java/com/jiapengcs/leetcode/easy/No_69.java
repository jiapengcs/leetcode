package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/5/15.
 *
 * 69. Sqrt(x)
 *
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
public class No_69 {
    // TC: unknown, SC: O(1)
    public static int mySqrt(int x) {
        double answer = x, tmp = 0;
        while (Math.abs(answer - tmp) > 0.000001) {
            tmp = answer;
            answer = (answer + x / answer) / 2;
        }
        return (int) answer;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(9801));
        System.out.println(mySqrt(2147395599));
    }
}
