package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng 2017/10/24.
 *
 * 62. Unique Paths
 *
 * 分析：走出迷宫的路径数。
 * 方法一：回溯法（超时）。
 * 方法二：动态规划，假设到达(m,n)位置的路径有F(m,n)条，因为只能向右或者向下走，所以到达(m,n)有两种情况：
 * (m-1,n) -> (m,n)或者(m,n-1) -> (m,n)，得到状态转移方程：F(m,n) = F(m-1,n) + F(m,n-1). 已知F(1,1) = 1.
 */
public class No_62 {
    public static int uniquePaths1(int m, int n) {
        List<List<int[]>> paths = new ArrayList<>();
        backtrack(m, n, 1, 1, new ArrayList<>(), paths);
        return paths.size();
    }

    public static void backtrack(int m, int n, int x, int y, List<int[]> path, List<List<int[]>> lists) {
        path.add(new int[]{x, y});
        if (x == m && y == n) {
            lists.add(new ArrayList<>(path));
        }
        if (x < m) {
            backtrack(m, n, x + 1, y, path, lists);
            path.remove(path.size() - 1);
        }
        if (y < n) {
            backtrack(m, n, x, y + 1, path, lists);
            path.remove(path.size() - 1);
        }
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }
}
