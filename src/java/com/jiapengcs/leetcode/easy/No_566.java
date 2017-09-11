package com.jiapengcs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jiapeng on 2017/6/23.
 *
 * 566. Reshape the Matrix
 *
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different
 * size but keep its original data.
 *
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row
 * number and column number of the wanted reshaped matrix, respectively.
 *
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order
 * as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise,
 * output the original matrix.
 *
 * Example 1:
 * Input:
 *   nums =
 *   [[1,2],
 *   [3,4]]
 *   r = 1, c = 4
 * Output:
 *   [[1,2,3,4]]
 * Explanation:
 *   The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the
 *   previous list.
 *
 * Example 2:
 * Input:
 *   nums =
 *   [[1,2],
 *   [3,4]]
 *   r = 2, c = 4
 * Output:
 *   [[1,2],
 *   [3,4]]
 * Explanation:
 *   There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 *
 * Note:
 *   The height and width of the given matrix is in range [1, 100].
 *   The given r and c are all positive.
 */
public class No_566 {
    // TC: O(n^2), SC: O(n)
    public static int[][] matrixReshape1(int[][] nums, int r, int c) {
        List<Integer> list = new ArrayList<>();
        for (int[] num : nums)
            for (int n : num)
                list.add(n);
        if (list.size() != r * c)
            return nums;
        int[][] answer = new int[r][c];
        int k = 0;
        for (int i = 0; i < r; i ++)
            for (int j = 0; j < c; j ++)
                answer[i][j] = list.get(k++);
        return answer;
    }

    // TC: O(n), SC: O(1)
    public static int[][] matrixReshape2(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c)
            return nums;
        int[][] answer = new int[r][c];
        for (int i = 0; i < r * c; i ++)
            answer[i/c][i%c] = nums[i/n][i%n];
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixReshape2(new int[][]{{1, 2}, {3, 4}}, 4, 1)));
        System.out.println(Arrays.deepToString(matrixReshape2(new int[][]{{1, 2, 3, 4}}, 2, 2)));
    }
}
