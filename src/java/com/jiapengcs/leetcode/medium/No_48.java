package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * Created by Jiapeng 2017/10/19.
 *
 * 48. Rotate Image
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 * Given input matrix =
 * [
 *  [1,2,3],
 *  [4,5,6],
 *  [7,8,9]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 *  [7,4,1],
 *  [8,5,2],
 *  [9,6,3]
 * ]
 *
 * Example 2:
 * Given input matrix =
 * [
 *  [ 5, 1, 9,11],
 *  [ 2, 4, 8,10],
 *  [13, 3, 6, 7],
 *  [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *  [15,13, 2, 5],
 *  [14, 3, 4, 1],
 *  [12, 6, 8, 9],
 *  [16, 7,10,11]
 * ]
 *
 * 分析：旋转二维数组。
 * 方法一：将二维数组看作多个环嵌套，依次对每个环上的元素进行旋转。（此方法效率较高，只需取数组的1/4）
 * 方法二：根据矩阵变换的性质，先左右对称变换，再做对角线变换。
 */
public class No_48 {
    // TC: O(n^2), SC: O(1)
    public static void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] param1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(param1);
        System.out.println(Arrays.deepToString(param1));

        int[][] param2 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(param2);
        System.out.println(Arrays.deepToString(param2));

        int[][] param3 = new int[][]{{5, 1, 9, 11, 17}, {2, 4, 8, 10, 12}, {13, 3, 6, 7, 16}, {15, 14, 12, 16, 21}, {11, 21, 28, 19, 18}};
        rotate(param3);
        System.out.println(Arrays.deepToString(param3));
    }
}
