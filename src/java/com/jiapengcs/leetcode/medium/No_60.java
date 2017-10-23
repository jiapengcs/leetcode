package com.jiapengcs.leetcode.medium;

/**
 * Created by Jiapeng on 2017/10/23.
 *
 * 60. Permutation Sequence
 *
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * 分析：假设n = 4, k = 10(转换为下标9), 则所有排列可以分成四组:
 * 1 + (2, 3, 4)
 * 2 + (1, 3, 4)
 * 3 + (1, 2, 4)
 * 4 + (1, 2, 3)
 * 而每个三元组有A(3, 3) = 6种排列, 即k / (n-1)! = 9 / 6 = 1可以确定第一位数字为2, k = k % (n-1)! = 3;
 * 对于剩下的(1, 3, 4), n = 3, k = 3, 同样地可以分成三组:
 * 1 + (3, 4)
 * 3 + (1, 4)
 * 4 + (1, 3)
 * k / (n-1)! = 1, 第二位数字为3, k = k % (n-1)! = 1;
 * 对于剩下的(1, 4), n = 2, k = 1, 同样地可以分成两组:
 * 1 + 4
 * 4 + 1
 * k / (n-1)! = 1, 第三位数字为4, 最后一位数字为1, 即得到结果2341.
 */
public class No_60 {
    public static String getPermutation(int n, int k) {

        return null;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 10));
    }
}
