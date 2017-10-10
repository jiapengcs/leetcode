package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Jiapeng 2017/10/10.
 *
 * 18. 4Sum
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 分析：与15题相比多一层遍历。
 */
public class No_18 {
    // TC: O(n^2), SC: O(n)
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums == null || nums.length < 4) return answer;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ) {
            for (int j = i + 1; j < nums.length - 2; ) {
                int head = j + 1, tail = nums.length - 1;
                while (head < tail) {
                    int sum = nums[i] + nums[j] + nums[head] + nums[tail];
                    if (sum == target) {
                        answer.add(Arrays.asList(nums[i], nums[j], nums[head], nums[tail]));
                    }
                    if (sum <= target) {
                        while (head < tail && nums[head] == nums[++head]);
                    }
                    if (sum >= target) {
                        while (head < tail && nums[tail] == nums[--tail]);
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[++j]);
            }
            while (i < nums.length - 3 && nums[i] == nums[++i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }
}
