package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng 2017/10/20.
 *
 * 54. Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 *
 * 分析：将矩阵视为多个环嵌套，依次遍历每层环，然后遍历最后一层m * 1(或1 * n)的矩阵。参考59题。
 */
public class No_54 {
    // TC: O(n), SC: O(1)
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return answer;
        int m = matrix.length, n = matrix[0].length;
        int c, t = Math.min(m, n) / 2;
        for (c = 0; c < t; c++, m -= 2, n -= 2) {
            for (int j = 0; j < n - 1; j++)
                answer.add(matrix[c][c + j]);
            for (int i = 0; i < m - 1; i++)
                answer.add(matrix[c + i][c + n - 1]);
            for (int j = n - 1; j > 0; j--)
                answer.add(matrix[c + m - 1][c + j]);
            for (int i = m - 1; i > 0; i--)
                answer.add(matrix[c + i][c]);
        }
        if (m == 1) {
            for (int j = 0; j < n; j++)
                answer.add(matrix[c][c + j]);
        } else if (n == 1){
            for (int i = 0; i < m; i++)
                answer.add(matrix[c + i][c]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4, 5}}));
        System.out.println(spiralOrder(new int[][]{{1}, {6}, {11}, {16}, {21}}));
        System.out.println(spiralOrder(new int[][]{}));
    }
}
