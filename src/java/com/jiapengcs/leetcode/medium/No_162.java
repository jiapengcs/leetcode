package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-12
 *
 * 162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 *
 * 分析：给定一个数组，找到山峰元素（该元素大于它的左右邻居）
 * 使用二分查找，如果mid小于high，则结果在mid+1和high之间；否则在low和mid之间。
 */
public class No_162 {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid+1]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return high;
    }
}
