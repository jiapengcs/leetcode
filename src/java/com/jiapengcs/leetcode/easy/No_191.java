package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/25
 *
 * 191. Number of 1 Bits
 *
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * 分析：位运算，本题重点在于无符号右移。
 * 每次判断最后一位是否为1，并且将n无符号右移一位；重复直到n为0.
 *
 * 一种新思路：每次n = n & (n-1)计算都会消去最低位的1（这就是为什么能判断一个数是否为2的幂），
 * 重复直到n为0，统计计算的次数，即1的个数。
 * 这种方法能比上述方法稍微快一点点，因为上述方法循环的次数取决于最高位1的位置，本方法循环的次数取决于比特1的个数。
 */
public class No_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n & 1);
            n >>>= 1;  // 无符号右移
        }
        return ans;
    }

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_191().hammingWeight(1));
        System.out.println(new No_191().hammingWeight(0x7fffffff));
        System.out.println(new No_191().hammingWeight(0x80000000));
        System.out.println(new No_191().hammingWeight(-1));
    }
}
