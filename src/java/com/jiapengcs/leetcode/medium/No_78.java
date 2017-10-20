package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng 2017/10/20.
 *
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 *
 * 分析：回溯法，参考39题的思路。
 */
public class No_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    public static void backtrack(int[] nums, int start, List<Integer> buf, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(buf));
        for (int i = start; i < nums.length; i++) {
            buf.add(nums[i]);
            backtrack(nums, i + 1, buf, lists);
            buf.remove(buf.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(null));
        System.out.println(subsets(new int[]{}));
        System.out.println(subsets(new int[]{1}));
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
