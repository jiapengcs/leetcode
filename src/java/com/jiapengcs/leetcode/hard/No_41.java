package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-23
 *
 * 41. First Missing Positive
 *
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * 分析：求数组第一个缺少的正整数。
 * 1~n范围内的元素可以作为数组的下标，通过修改对应位置的元素来记录是否访问过。1~n范围之外的元素则忽略（置为0）。
 */
public class No_41 {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > n || nums[i] < 0) {  //将大小不在1~n范围内的元素置为0
                nums[i] = 0;
            }
        }
        for (int index : nums) {
            if (index > 0) {
                index = (index - 1) % n;  //计算有效下标index
                nums[index] += 2 * n;  //将nums[index]加上两倍的数组长度，确保出现过的下标对应元素大于数组长度
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {  //不大于数组长度的元素的下标没有出现过，输出第一个这样的下标
                return i + 1;
            }
        }
        return n + 1;  //所有下标都出现过，则输出最大下标的下一个数字
    }

    public static void main(String[] args) {
        System.out.println(new No_41().firstMissingPositive(new int[]{5,3,1}));
    }
}
