package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-16
 *
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * 分析：回溯法
 * 先找到有效的起始点，再对它进行回溯，为了避免走“回头路”，可以用一个visited数组对处于当前路径的点进行标记，
 * 也可以看情况使用bitmap等方法减少使用额外内存。
 */
public class No_79 {

    public static boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || word == null) {
            return false;
        }
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && findPath2(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findPath(char[][] board, String word, boolean[][] visited, int x, int y, int index) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        // 通过短路避免不必要的搜索
        boolean result = findPath(board, word, visited, x+1, y, index+1)
                || findPath(board, word, visited, x-1, y, index+1)
                || findPath(board, word, visited, x, y-1, index+1)
                || findPath(board, word, visited, x, y+1, index+1);
        visited[x][y] = false;
        return result;
    }

    public static boolean findPath2(char[][] board, String word, int x, int y, int index) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        // char类型占2字节，即16bit，但这些字母的表示不超过8bit，通过往高位赋1来标记已访问
        board[x][y] ^= 256;
        // 通过短路避免不必要的搜索
        boolean result = findPath2(board, word, x+1, y, index+1)
                || findPath2(board, word, x-1, y, index+1)
                || findPath2(board, word, x, y-1, index+1)
                || findPath2(board, word, x, y+1, index+1);
        board[x][y] ^= 256;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'a', 'b', 'c', 'e'},
                {'s', 'e', 'c', 'e'},
                {'a', 'd', 'e', 's'}
        }, "abccedase"));
    }
}
