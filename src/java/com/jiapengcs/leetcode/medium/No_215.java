package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/30
 *
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * 分析：快速选择(quick select)
 * 每次只需要对特定的一半进行递归，最好的情况下，n/2 + n/4 + n/8 + ... = O(n); 最坏的情况下（有序），n + n-1 + n-2 + ... = O(n^2).
 */
public class No_215 {

    // 讨论区答案
    // TC: O(n), SC: O(1)
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, n-k+1, 0, n-1);
    }

    public static int quickSelect(int[] nums, int k, int start, int end) {
        int i = start, j = end, pivot = nums[end];
        while (i < j) {
            if (nums[i++] > pivot) {
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, end);
        int m = i - start + 1;
        if (m == k) {
            return nums[i];
        } else if (m > k) {
            return quickSelect(nums, k, start, i-1);
        } else {
            return quickSelect(nums, k-m, i+1, end);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // TC: O(nlogn), SC: O(1)
    public static int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
