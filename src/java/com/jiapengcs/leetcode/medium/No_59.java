package com.jiapengcs.leetcode.medium;

import java.util.Arrays;

/**
 * Created by Jiapeng on 2017/10/20.
 *
 * 59. Spiral Matrix II
 *
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 分析：与54题的思路类似。
 * 将矩阵视为嵌套的多个环，每层分别遍历四条边。比如上面的例子，遍历的顺序为(1, 2), (3, 4), (5, 6), (7, 8)。最后加上最里层的单个元素9。
 */
public class No_59 {
    // TC: O(n^2), SC: O(n^2)
    public static int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int i, len = n, num = 1;
        for (i = 0; i < n / 2; i++, len -= 2) {
            for (int j = 0; j < len - 1; j++)
                answer[i][i + j] = num++;
            for (int j = 0; j < len - 1; j++)
                answer[i + j][i + len - 1] = num++;
            for (int j = len - 1; j > 0; j--)
                answer[i + len - 1][i + j] = num++;
            for (int j = len - 1; j > 0; j--)
                answer[i + j][i] = num++;
        }
        if ((n & 1) == 1) answer[i][i] = num;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(0)));
        System.out.println(Arrays.deepToString(generateMatrix(1)));
        System.out.println(Arrays.deepToString(generateMatrix(2)));
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix(4)));
        System.out.println(Arrays.deepToString(generateMatrix(5)));
        System.out.println(Arrays.deepToString(generateMatrix(6)));
    }
}
