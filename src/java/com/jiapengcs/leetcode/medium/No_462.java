package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 462. Minimum Moves to Equal Array Elements II
 *
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 2
 *
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 * 分析：每次可以对一个元素加一或减一，求最少需要多少次操作能使所有元素相等。
 * 这里会自然会想到先求数组的平均值，然后计算每个元素与平均值的差的绝对值之和。
 * 尝试后发现是不对的，例如输入[1,2,100]，平均值为34，总次数为131，如果分别1,2,100，则分别需要100，99，197次。
 * 猜想应选择中位数，
 * 证明：[1, 99, ..., 2, 100]，
 * 假设当前1和100分别为当前的最小值最大值，则在它们之间无论选哪个，对这两个数的操作次数总是相等的，
 * 问题转化为求[99, ..., 2]的解，缩小到最后只剩下中位数。
 */
public class No_462 {

    public int minMoves2(int[] nums) {
        int k = (nums.length + 1) / 2;
        int mid = findKth(nums, 0, nums.length - 1, k);
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - mid);
        }
        return ans;
    }

    private int findKth(int[] nums, int start, int end, int k) {
        int low = start, high = end, pivot = nums[end];
        while (low < high) {
            if (nums[low++] > pivot) {
                swap(nums, --low, --high);
            }
        }
        swap(nums, low, end);
        int m = low - start + 1;
        if (m == k) {
            return nums[low];
        } else if (m > k) {
            return findKth(nums, start, low - 1, k);
        } else {
            return findKth(nums, low + 1, end, k - m);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //--------------直接排序-----------------
    // 提交结果：直接排序的耗时比上述快速选择的耗时更长，推测可能的原因是数组有序，导致快速选择退化为O(n^2)。
    public int minMoves22(int[] nums) {
        Arrays.sort(nums);
        int k = nums.length / 2;
        int mid = nums[k];
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - mid);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_462().minMoves2(new int[]{1, 2, 100}));
    }
}
