package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-20
 *
 * 96. Unique Binary Search Trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 分析：动态规划
 * 假设要构造二叉树{1, 2, 3, 4, 5}，可以依次选择每个数字作为根节点：
 * root = 1时，左子树为空（1种组合），右子树由{2, 3, 4, 5}组成（与{1, 2, 3, 4}组合数一样，共dp[4]种），左右相乘得dp[0] * dp[4]；
 * root = 2时，共dp[1] * dp[3]种；
 * ...
 * 综上：dp[5] = dp[0]*dp[4] + dp[1]*dp[3] + dp[2]*dp[2] + dp[3]*dp[1] + dp[4]*dp[0];
 */
public class No_96 {
    // TC: O(n^2), SC: O(n)
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
    }
}
