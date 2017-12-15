package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-14
 *
 * 31. Next Permutation
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 分析：
 * (1) 从低位到高位，找到a[i], 满足a[i-1] < a[i];
 * (2) 再从a[i]到最低位（递减序列）中找到刚刚大于a[i-1]的位置a[j], 交换a[i-1]和a[j];
 * (3) 再将从a[i]到最低位（递减序列）翻转（成递增序列）。
 * 例如： 9 4 6 5 3 1
 * (1) a[i] = 6, a[i-1] = 4;
 * (2) a[j] = 5, 交换得: 9 5 6 4 3 1
 * (3) 翻转a[i]到最低位的序列得: 9 5 1 3 4 6
 */
public class No_31 {
    // TC: O(n), SC: O(1)
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i-1]) {
            i--;
        }
        if (i > 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i-1]) {
                j--;
            }
            swap(nums, i-1, j);
        }
        reverse(nums, i);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{9, 4, 6, 5, 3, 1};
        int[] nums = new int[]{1, 1, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
