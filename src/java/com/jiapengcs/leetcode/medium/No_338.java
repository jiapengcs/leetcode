package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-3
 *
 * 338. Counting Bits
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
 * in their binary representation and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Follow up:
 *  1.It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 *  But can you do it in linear time O(n) /possibly in a single pass?
 *  2.Space complexity should be O(n).
 *  3.Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or
 *  in any other language.
 *
 * 分析：给定一个非负整数num，返回从0～num每个数的二进制中比特1的个数。要求对每个数求解时复杂度为O(1).
 */
public class No_338 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int tmp = 1;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i < tmp * 2) {
                dp[i] = dp[tmp] + dp[i - tmp];
            } else {
                dp[i] = 1;
                tmp *= 2;
            }
        }
        return dp;
    }

    public int[] countBits2(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);  //i相比于i/2，最右边增加了一位，判断增加的是1还是0，然后加上dp[i/2].
        }
        return dp;
    }

    //------------------------------------------------
    //O(1)时间求某个数的比特1的个数。
    public int countBit(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);  //消除最低位的1
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new No_338().countBit(0));
        System.out.println(new No_338().countBit(7));
        System.out.println(new No_338().countBit(8));
        System.out.println(new No_338().countBit(0x7fffffff));
        System.out.println(new No_338().countBit(0x80000000));
    }
}
