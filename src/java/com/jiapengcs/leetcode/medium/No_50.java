package com.jiapengcs.leetcode.medium;

/**
 * Created by Jiapeng 2017/10/19.
 *
 * 50. Pow(x, n)
 *
 * Implement pow(x, n).
 *
 * 分析：实现幂运算
 * 二分法。指数为正数时，将指数n以二进制表示，如果最低位为1，则answer需要乘以x，为0则不乘；然后将n >> 1，x *= x，重复上述步骤。
 * 指数为负数时，将x^(-n)变换为(1/x)^n。
 */
public class No_50 {
    // TC: O(log(n)), SC: O(1)
    public static double myPow(double x, int n) {
        double answer = 1.0;
        long index = (long) n;
        if (index < 0) {
            index = -index;
            x = 1 / x;
        }
        while (index > 0) {
            if ((index & 1) == 1) {
                answer *= x;
            }
            index >>= 1;
            x *= x;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(myPow(0, -2));
        System.out.println(myPow(0, 0));
        System.out.println(myPow(2, 0));
        System.out.println(myPow(-3, -3));
        System.out.println(myPow(-3, 3));
        System.out.println(myPow(2, -10));
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.333333, 10));
        System.out.println(myPow(0.99, 365));
        System.out.println(myPow(1.01, 365));
        System.out.println(myPow(2, -2147483648));
    }
}
