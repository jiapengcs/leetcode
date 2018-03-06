package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-22
 *
 * 52. N-Queens II
 *
 * 分析：求n皇后问题的解法有多少种。经典回溯法问题。
 * 每个皇后所在的行、列和左右对角线都不能存在另一个皇后。
 * 每次递归移动到下一行可以避免一行存在多个皇后，列和左右对角线可以用数组来记录是否已经存在皇后，
 * 一共有n列，左、右对角线各2n-1条。
 * 当行号等于n时，说明此时得到一个解，计数值count加一。
 * 回溯时清除标记。
 */
public class No_52 {
    private int count = 0;

    public int totalNQueens(int n) {
        backtracking(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return count;
    }

    private void backtracking(int row, int n, boolean[] cols, boolean[] x1, boolean[] x2) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int a = row - col + n, b = 2 * n - row - col - 1;
            if (!cols[col] && !x1[a] && !x2[b]) {
                cols[col] = x1[a] = x2[b] = true;
                backtracking(row + 1, n, cols, x1, x2);
                cols[col] = x1[a] = x2[b] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new No_52().totalNQueens(13));
    }
}
