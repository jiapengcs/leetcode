package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/30
 *
 * 507. Perfect Number
 *
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 *
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 *
 * 分析：因为输入达到1e8量级，直接求解很可能会超时。
 * 简化的思路与判断素数类似，以num=100为例，我们从2开始累加能整除num的除数，同时加上整除后的商：
 * 即+2, +50, +4, + 25, +5, +20, +10, +10, 这样只需查找到num的平方根即可，时间复杂度为O(n^1/2)
 */
public class No_507 {
    // TC: O(n^1/2), SC: O(1)
    public static boolean checkPerfectNumber(int num) {
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += (i + num/i);
            }
        }
        return num != 1 && sum == num;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
}
