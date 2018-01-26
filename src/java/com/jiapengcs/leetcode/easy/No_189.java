package com.jiapengcs.leetcode.easy;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/25
 *
 * 189. Rotate Array
 *
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * 分析：原理：YX = (XTYT)T (T表示转置)
 * 左旋k位时，先对k取模，即k %= len
 * （1）将前k个元素逆置；
 * （2）将后len-k个元素逆置；
 * （3）将所有元素逆置。
 */
public class No_189 {
    // TC: O(n), SC: O(1)
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        for (int i = 0, j = nums.length - k - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        for (int i = nums.length - k, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new No_189().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
