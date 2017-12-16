package com.jiapengcs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/16
 *
 * 73. Set Matrix Zeroes
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 * 分析：
 * 1.第一次遍历用两个List分别记录出现0的行和列，第二次遍历对这些行、列赋值，空间复杂度为O(n)；
 * 2.在1的基础上改进，用每行、每列的第一个元素来记录是否出现0，第0行、第0列的第一个元素重合在matrix[0][0]，
 * 因此增加一个col0来记录第0列的状态，空间复杂度降为O(1)。第二次遍历时，为了避免行、列首因赋值产生的0对后面位置的干扰，
 * 应先对行、列尾赋值，最后对行、列首赋值。
 */
public class No_73 {
    // TC: O(m*n), SC: O(1)
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, col0 = 1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }

    // TC: O(m*n), SC: O(m+n)
    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 0, 0, 5},
                {4, 3, 1, 4},
                {0, 1, 1, 4},
                {1, 2, 1, 3},
                {0, 0, 1, 1}
        };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
