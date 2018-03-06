package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 453. Minimum Moves to Equal Array Elements
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required
 * to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * 分析：数组每次对任意n-1个元素加一，求最少需要多少次操作能使所有元素相等。
 * 逆向思考，数组每次对任意n-1个元素加一，相当于每次对1个元素减一，问题转化为每个元素与最小元素的差之和。
 */
public class No_453 {
    public int minMoves(int[] nums) {
        int min = 0x7fffffff;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int ans = 0;
        for (int num : nums) {
            ans += (num - min);
        }
        return ans;
    }
}
