package com.jiapengcs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-22
 *
 * 51. N-Queens
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 * [".Q..",  // Solution 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 *
 * ["..Q.",  // Solution 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 *
 * 分析：求n皇后问题的所有解法。
 * 参考52题的思路。
 * 增加一个二维数组记录棋盘，初始全部为'.'，在某个位置摆放皇后时修改为'Q'，行号等于n时说明得到一个解，将棋盘拷贝至结果。
 * 回溯时恢复原来的状态。
 */
public class No_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtracking(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n], board, ans);
        return ans;
    }

    private void backtracking(int row, int n, boolean[] cols, boolean[] x1, boolean[] x2, char[][] board, List<List<String>> result) {
        if (row == n) {  //得到解，保存到result
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            result.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            int a = row - col + n, b = 2 * n - row - col - 1;
            if (!cols[col] && !x1[a] && !x2[b]) {
                board[row][col] = 'Q';  //摆放皇后
                cols[col] = x1[a] = x2[b] = true;
                backtracking(row + 1, n, cols, x1, x2, board, result);
                board[row][col] = '.';  //回溯
                cols[col] = x1[a] = x2[b] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> ans = new No_51().solveNQueens(8);
        for (List<String> list : ans) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("****************");
        }
    }
}
