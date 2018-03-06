package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-26
 *
 * 342. Power of Four
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 *
 * Follow up: Could you solve it without loops/recursion?
 *
 * 分析：判断一个数是否4的幂。
 * 假如一个数是4的幂，则比特1一定出现在奇数位，从而有(num & 0xaaaaaaaa) == 0；
 * 但是num = 5,20,80...时也满足上述等式，因此先判断是否为2的幂。
 */
public class No_342 {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}
