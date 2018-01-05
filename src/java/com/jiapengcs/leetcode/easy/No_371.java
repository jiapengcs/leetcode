package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-2
 *
 * 371. Sum of Two Integers
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class No_371 {

    public static int getSum(int a, int b) {
        int sum = a ^ b, carry = (a & b) << 1;
        while (carry != 0) {
            a = sum;
            b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(12341, 123513));
    }
}
