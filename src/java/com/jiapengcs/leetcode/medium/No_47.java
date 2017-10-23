package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jiapeng 2017/10/23.
 *
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 *  [1,1,2],
 *  [1,2,1],
 *  [2,1,1]
 * ]
 *
 * 分析：46题的变种。回溯法，参考39题的思路。
 * 此题难点在于如何解决跳过重复元素与跳过重复组合的矛盾，方法是用一个visited数组来记录元素是否已被访问。
 */
public class No_47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), answer);
        return answer;
    }

    public static void backtrack(int[] nums, boolean[] visited, List<Integer> buf, List<List<Integer>> lists) {
        if (buf.size() == nums.length) {
            lists.add(new ArrayList<>(buf));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            buf.add(nums[i]);
            backtrack(nums, visited, buf, lists);
            buf.remove(buf.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
        System.out.println(permuteUnique(new int[]{3, 3, 0, 3}));
    }
}
