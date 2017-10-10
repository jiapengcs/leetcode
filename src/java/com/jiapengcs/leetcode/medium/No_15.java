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
 */
public class No_15 {
    // TC: O(n^2), SC: O(n)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

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
