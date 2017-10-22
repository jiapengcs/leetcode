package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng on 2017/10/22.
 *
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 *
 * 分析：回溯法，参考39题的思路。
 */
public class No_77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(n, k, 0, new ArrayList<>(), answer);
        return answer;
    }

    public static void backtrack(int n, int k, int start, List<Integer> buf, List<List<Integer>> lists) {
        if (buf.size() == k) {
            lists.add(new ArrayList<>(buf));
            return;
        }
        for (int i = start; i < n; i++) {
            buf.add(i+1);
            backtrack(n, k, i + 1, buf, lists);
            buf.remove(buf.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(1, 2));
    }
}
