package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-14
 *
 * 36. Valid Sudoku
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class No_36 {
    // TC: O(n^2), SC: O(n)
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                int r = 3 * (i / 3), c = 3 * (i % 3);
                if (board[r + j / 3][c + j % 3] != '.' && !cube.add(board[r + j / 3][c + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        List<Character> buf = new ArrayList<>(9);
        for (int i = 0; i < board.length; i++) {
            buf.clear();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (buf.contains(board[i][j])) {
                        return false;
                    }
                    buf.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            buf.clear();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (buf.contains(board[j][i])) {
                        return false;
                    }
                    buf.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                buf.clear();
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i+m][j+n] != '.') {
                            if (buf.contains(board[i+m][j+n])) {
                                return false;
                            }
                            buf.add(board[i+m][j+n]);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
