package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/5/15.
 *
 * 367. Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: 16
 * Returns: True
 *
 * Example 2:
 * Input: 14
 * Returns: False
 */
public class No_367 {
    // Brute Force => TC: O(sqrt(n)), SC: O(1)
    public static boolean isPerfectSquare1(int num) {
        for (int i = 1; i <= num; i++) {
            long tmp = (long) i * i;
            if (tmp == num) {
                return true;
            } else if (tmp > num) {
                return false;
            }
        }
        return false;
    }

    // Binary Search => TC: O(log(n)), SC: O(1)
    public static boolean isPerfectSquare2(int num) {
        long l = 1, r = num;
        while (l <= r) {
            long tmp = (l + r) / 2;
            if (tmp * tmp == num) {
                return true;
            } else if (tmp * tmp > num) {
                r = tmp - 1;
            } else {
                l = tmp + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare1(1));
        System.out.println(isPerfectSquare1(25));
        System.out.println(isPerfectSquare1(2147483647));
    }
}
