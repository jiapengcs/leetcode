package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jiapeng 2017/10/17.
 *
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C
 * where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 *   [7],
 *   [2, 2, 3]
 * ]
 *
 * 分析：在给定的没有重复元素的数组中找出和为target的组合，组合中同一元素可以重复出现。
 * 采用回溯法。对于每一个元素，从左到右将各个元素尽可能多的重复加入，如果超出target则回退，注意剪枝。
 * 过程如下（括号内为当前状态）：
 * (0) + 2 < 7
 * (2) + 2 < 7
 * (2 + 2) + 2 < 7
 * (2 + 2 + 2) + 2 > 7, 回退至(2 + 2), 不必再往后尝试(2 + 2 + 2) + 3...
 * (2 + 2) + 3 == 7, 将(2, 2, 3)加入结果集, 回退至(2 + 2), 不必再往后尝试(2 + 2) + 6...
 * (2 + 2) + 4 > 7, 回退至2
 * (2) + 3 < 7,
 * ...
 */
public class No_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                buf.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, buf, list);
                buf.remove(buf.size() - 1);
            }
        }
    }

    public static void backtrack2(int[] candidates, int target, int index, List<Integer> buf, List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(buf));
            return;
        }
        if (candidates[index] <= target) {
            buf.add(candidates[index]);
            backtrack(candidates, target - candidates[index], index, buf, list);
            buf.remove(buf.size() - 1);
            while (index + 1 < candidates.length && candidates[index + 1] <= target) {
                buf.add(candidates[++index]);
                backtrack(candidates, target - candidates[index], index, buf, list);
                buf.remove(buf.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 6, 5, 7}, 7));
    }
}
