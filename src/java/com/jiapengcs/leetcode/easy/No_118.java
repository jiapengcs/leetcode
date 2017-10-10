package com.jiapengcs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng on 2017/9/26.
 *
 * 118. Pascal's Triangle
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * 分析：求前n阶杨辉三角
 * 方法一：首尾插入1，其他值通过前一阶的关系相加得到。
 * 方法二：直接对当前阶的运算得到。
 */
public class No_118 {
    // TC: O(n^2), SC: O(n^2)
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                    continue;
                }
                list.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            ans.add(list);
        }
        return ans;
    }

    // TC: O(n^2), SC: O(n^2)
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generate2(5));
    }
}
