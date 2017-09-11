package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/5/15.
 *
 * 461. Hamming Distance
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 2^31.
 *
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 *
 * Thinking:
 *   Bitwise Operation.
 */
public class No_461 {
    // TC: O(log(n)), SC: O(1)
    public static int hammingDistance1(int x, int y) {
        int dist = 0;
        while (x > 0 || y > 0) {
            if (x % 2 !=  y % 2)
                dist++;
            x = x >> 1;
            y = y >> 1;
        }
        return dist;
    }

    // TC: O(log(n)), SC: O(1)
    public static int hammingDistance2(int x, int y) {
        int tmp = x ^ y;
        int dist = 0;
        while (tmp > 0) {
            if ((tmp & 1) == 1)
                dist++;
            tmp >>= 1;
        }
        return dist;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance1(1, 4));
        System.out.println(hammingDistance1(93, 73));
        System.out.println(hammingDistance1(85, 73));
    }
}
