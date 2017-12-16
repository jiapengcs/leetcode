package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/16
 *
 * 74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * For example,
 * Consider the following matrix:
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 *
 * 分析：
 * 将二维数组看成大小为k(k=m*n)的一维数组array[]，array[k]映射为matrix[k/m][k%n]，进行二分查找。
 */
public class No_74 {
    // TC: O(log(m+n)), SC: O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length, low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == matrix[mid / n][mid % n]) {
                return true;
            }
            if (target > matrix[mid / n][mid % n]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 100));
    }
}
