package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/15
 *
 * 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 * Example 1:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 *
 * 分析：动态规划
 * 计算到达每一个点的最小sum，后一个点的sum值依赖于它左方或者上方较小的那个值。
 * 1.此题如果不要求保留输入值，可以就地修改二维数组，不需要额外的空间；
 * 2.如果不能修改输入值，需要创建一个二维数组dp[][]，空间复杂度为O(n^2)；
 * 3.通过方法二，可以将额外空间降为一维数组dp[n](n为列数)：
 *      因为计算过程是按行进行的，用dp[]记录上一行的状态，遍历到某一行的第j个位置时，
 *      dp[j]表示这个位置的上方的状态（dp[j]还未被修改，仍然保留了上一行的状态），
 *      dp[j-1]表示这个位置的左方的状态（dp[j-1]在刚刚遍历到第j-1个位置时已经更新过），
 *      计算当前位置的dp值，并更新dp[j]。
 */
public class No_64 {
    // TC: O(n^2), SC: O(1)
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    // // TC: O(n^2), SC: O(n)
    public static int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum2(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
}
