package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-27
 *
 * 130. Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 分析：DFS
 */
public class No_130 {

    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'O') {
            board[x][y] = '*';
        }
        if (x-1 > 0 && board[x-1][y] == 'O') {
            dfs(board, x-1, y);
        }
        if (x+1 < board.length-1 && board[x+1][y] == 'O') {
            dfs(board, x+1, y);
        }
        if (y-1 > 0 && board[x][y-1] == 'O') {
            dfs(board, x, y-1);
        }
        if (y+1 < board[0].length-1 && board[x][y+1] == 'O') {
            dfs(board, x, y+1);
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X',  'X', 'X', 'X'},
                {'X',  'O', 'O', 'X'},
                {'X',  'X', 'O', 'X'},
                {'X',  'O', 'X', 'X'},
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
