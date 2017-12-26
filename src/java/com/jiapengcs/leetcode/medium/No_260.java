package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-21
 *
 * 260. Single Number III
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
 * exactly twice. Find the two elements that appear only once.
 *
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 * 分析：与第136题思路类似，通过按位异或消去相同的数，因为有两个落单的数字，所以应采用某种方式将原数组分成两部分处理。
 * 第一次遍历将所有元素按位异或，得到x ^ y的值t（x, y即要找的两个数），t的二进制中，出现1的位置都是x, y的不同之处，
 * 任意取一个出现1的位置（可以通过t & -t取最低位的1），与原数组的元素按位与，根据该位置是否出现1将原数组分成分别
 * 包含x, y的两部分（相同的数一定会被分到同一部分），然后分别将这两部分按位异或。
 */
public class No_260 {
    public static int[] singleNumber(int[] nums) {
        int t = 0;
        for (int num : nums) {
            t ^= num;
        }
        t &= -t;
        int[] answer = new int[2];
        for (int num : nums) {
            if ((t & num) != 0) {
                answer[0] ^= num;
            } else {
                answer[1] ^= num;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
