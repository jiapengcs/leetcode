package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jiapeng 2017/10/17.
 *
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
 * where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 *  [1, 7],
 *  [1, 2, 5],
 *  [2, 6],
 *  [1, 1, 6]
 * ]
 *
 * 分析：此题为39题的变种，在给定的允许有重复元素的数组中找出和为target的组合，组合中同一元素不能重复出现。
 * 解法与39题相似。区别之处在于不能将自身重复加入，且同一层迭代中，应跳过相同的元素。
 */
public class No_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    public static void backtrack(int[] candidates, int target, int start, List<Integer> buf, List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(buf));
        } else if (target > 0) {
            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {  // candidates[i] <= target: pruning
                if (i > start && candidates[i] == candidates[i - 1]) {  // skip the duplicate elements during an iteration
                    continue;
                }
                buf.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, buf, list);  // i + 1: skip itself
                buf.remove(buf.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
