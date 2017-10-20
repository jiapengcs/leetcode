package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jiapeng 2017/10/20.
 *
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 *
 * 分析：回溯法，参考39题的思路。
 */
public class No_90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    public static void backtrack(int[] nums, int start, List<Integer> buf, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(buf));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            buf.add(nums[i]);
            backtrack(nums, i + 1, buf, lists);
            buf.remove(buf.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }
}
