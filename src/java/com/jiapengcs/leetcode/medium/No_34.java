package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * Created by Jiapeng 2017/10/17.
 *
 * 34. Search for a Range
 *
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * 分析：查找数组中等于target的元素下标范围。复杂度要求O(log n)，通过二分法解决。
 * 用二分法分别找出值等于target且下标最小、最大的元素。
 */
public class No_34 {
    // TC: O(log(n)), SC: O(1)
    public static int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int tmp = low;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return tmp <= high ? new int[]{tmp, high} : new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 9)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 8, 8, 8, 8, 8, 10}, 8)));
    }
}
