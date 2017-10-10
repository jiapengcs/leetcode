package com.jiapengcs.leetcode.medium;

import java.util.*;

/**
 * Created by Jiapeng on 2017/6/28.
 *
 * 15. 3Sum
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 分析：求数组中和为零的三元组。
 * 先将数组排序，对每个元素，从它后面的元素中找两个数，使得三个数的和为零。查找过程使用双指针，如果和小于零则低位指针右移，和大于零
 * 则高位左移。注意跳过重复的元素。
 */
public class No_15 {
    // TC: O(n^2), SC: O(n)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int head = i + 1, tail = nums.length - 1;
                while (head < tail) {
                    int sum = nums[i] + nums[head] + nums[tail];
                    if (sum == 0) {
                        answer.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    }
                    if (sum <= 0) {
                        while (head < tail && nums[head] == nums[++head]);
                    }
                    if (sum >= 0) {
                        while (head < tail && nums[tail] == nums[--tail]);
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1, 2, -3, 4, -2}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
        System.out.println(threeSum(new int[]{-2, -1, -1, 0, 2}));
        System.out.println(threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
        System.out.println(threeSum(new int[]{2}));
        System.out.println(threeSum(new int[]{}));
    }
}
