package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-21
 *
 * 137. Single Number II
 *
 * Given an array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * 分析：此类题目在于统计每个比特位1出现的次数。
 * 方法一：对于int类型，统计32bit每一位上1出现的次数，然后模3，余下1次就是single number出现的，
 * 这种方法是通用的，如出现3次改为出现5次，只需将模3改为模5.
 * 方法二：用one记录出现一次的bit，two记录出现两次的bit，three记录出现三次的bit，
 * 每当有出现三次的bit时，将one，two中出现三次的bit置为0.
 */
public class No_137 {
    // TC: O(n), SC: O(1)
    public static int singleNumber(int[] nums) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    count++;
                }
            }
            count %= 3;
            answer |= count << i;
        }
        return answer;
    }

    // TC: O(n), SC: O(1)
    public static int singleNumber2(int[] nums) {
        int one = 0, two = 0, three;
        for (int num :nums) {
            two |= one & num;
            one ^= num;
            three = one & two;
            one = one & ~three;
            two = two & ~three;
        }
        return one;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[]{1,1,1,2,3,3,3}));
        System.out.println(0xffffffff);
    }
}
