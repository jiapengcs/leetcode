package com.jiapengcs.leetcode.hard;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.ArrayList;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-8
 *
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * For example:
 * Given the below binary tree,
 *     1
 *    / \
 *   2   3
 * Return 6.
 *
 * 分析：求树的最大路径和。
 * 难点主要在于对负数的处理，用全局变量maxSum记录最大路径和，如果子树为负值则不走子树（子树的路径和为0）。
 * 递归返回较大的那条路径，即左右子树中较大的值加上根结点。
 * 这里不能返回整体的最大值，因为我们求的路径只是整条路径的一部分，不能同时通过左右子树，否则不能再往上走了。
 */
public class No_124 {
    private int maxSum = 0x80000000;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    public int maxPathSumHelper(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(0, maxPathSumHelper(root.left));
        int rightSum = Math.max(0, maxPathSumHelper(root.right));
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
