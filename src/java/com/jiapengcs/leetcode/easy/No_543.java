package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-3
 *
 * 543. Diameter of Binary Tree
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is
 * the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *      1
 *     / \
 *    2   3
 *   / \
 *  4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * 分析：求树的最大路径长度。路径可以不经过root结点。
 */
public class No_543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        ans = Math.max(ans, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
