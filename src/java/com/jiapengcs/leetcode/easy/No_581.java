package com.jiapengcs.leetcode.easy;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-24
 *
 * 581. Shortest Unsorted Continuous Subarray
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending
 * order, then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 *
 * 分析：找数组中无序部分的长度。
 * 方法一：拷贝数组并排序，与原数组比较找出第一个和最后一个不同的位置，计算得到无序部分的长度；
 * 方法二：从左往右遍历，每个遇到的元素理论上应该是当前的最大值，如果不是则表明该位置无序，找到最后一个无序的位置；
 * 同理，从右往左遍历，每个遇到的元素理论上应该是当前的最小值，如果不是则表明该位置无序，找到第一个无序的位置；
 * 计算得到无序部分的长度。
 */
public class No_581 {

    // TC: O(nlogn), SC: O(n)
    public int findUnsortedSubarray1(int[] nums) {
        int len = nums.length;
        int[] buf = new int[len];
        for (int i = 0; i < len; i++) {
            buf[i] = nums[i];
        }
        Arrays.sort(buf);
        int start = 0, end = len - 1;
        for (; start < len && buf[start] == nums[start]; start++);
        for (; end >= 0 && buf[end] == nums[end]; end--);
        return start < end ? end - start + 1 : 0;
    }

    // TC: O(n), SC: O(1)
    public int findUnsortedSubarray(int[] nums) {
        int start = 0, end = -1;
        int max = 0x80000000, min = 0x7fffffff;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            max = Math.max(max, nums[i]);
            if (max != nums[i]) {
                end = i;
            }
            min = Math.min(min, nums[j]);
            if (min != nums[j]) {
                start = j;
            }
        }
        return end - start + 1;
    }
}
