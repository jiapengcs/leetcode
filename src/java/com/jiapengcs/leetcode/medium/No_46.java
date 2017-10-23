package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng 2017/10/23.
 *
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * 46. Permutations
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 *
 * 分析：回溯法，参考39题的思路。
 */
public class No_46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), answer);
        return answer;
    }

    public static void backtrack(int[] nums, List<Integer> buf, List<List<Integer>> lists) {
        if (buf.size() == nums.length) {
            lists.add(new ArrayList<>(buf));
        }
        for (int i = 0; i < nums.length; i++) {
            if (buf.contains(nums[i])) continue;
            buf.add(nums[i]);
            backtrack(nums, buf, lists);
            buf.remove(buf.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
