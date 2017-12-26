package com.jiapengcs.leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-25
 *
 * 120. Triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * 分析：
 * 方法一：从上往下，每一层从右边开始遍历，用dp[n]记录当前层的状态，最后输出dp[n]中的最小值；
 * 方法二：从下往上，直接从第n-1层往上遍历，用triangle本身来记录状态，可以不使用额外空间（如果不能修改triangle可以借助dp[n]）。
 */
public class No_120 {
    // TC: O(n^2), SC: O(n)
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int dp[] = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int len = triangle.get(i).size();
            for (int j = len-1; j >= 0; j--) {
                int x = triangle.get(i).get(j);
                if (j == len-1) {
                    dp[j] = dp[j-1] + x;
                } else if (j == 0) {
                    dp[j] += x;
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + x;
                }
            }
        }
        int ans = 0x7fffffff;
        for (int i : dp) {
            ans = Math.min(ans, i);
        }
        return ans;
    }

    // TC: O(n^2), SC: O(1)
    public static int minimumTotal2(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(-1);
        List<Integer> list2 = Arrays.asList(2, 3);
        List<Integer> list3 = Arrays.asList(1, -1, -3);
        List<List<Integer>> lists = Arrays.asList(list1, list2, list3);
        System.out.println(minimumTotal2(lists));
    }
}
