package com.jiapengcs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng on 2017/9/26.
 *
 * 119. Pascal's Triangle II
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * 分析：求第n阶杨辉三角
 * 方法一：借鉴118题的解法二，可以节约空间
 * 方法二：利用杨辉三角的性质，每一项其实是组合数C(m,n).通过数学方法计算，复杂度降为O(n).
 */
public class No_119 {
    // TC: O(n^2), SC: O(n)
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(0, 1);
            for (int j = 1; j < ans.size() - 1; j++) {
                ans.set(j, ans.get(j) + ans.get(j + 1));
            }
        }
        return ans;
    }

    // TC: O(n), SC: O(n)
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            int tmp = (int) ((long) ans.get(i - 1) * (rowIndex - i + 1) / i);  //multiple may overflow for int
            ans.add(i, tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
        System.out.println(getRow2(30));
    }
}
