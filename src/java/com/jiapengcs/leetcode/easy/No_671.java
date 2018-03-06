package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 671. Second Minimum Node In a Binary Tree
 *
 * Given a non-empty special binary tree consisting of nodes with the non-negative value,
 * where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
 * then this node's value is the smaller value among its two sub-nodes.
 *
 * Given such a binary tree, you need to output the second minimum value
 * in the set made of all the nodes' value in the whole tree.
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 * Input:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *
 * Example 2:
 * Input:
 *    2
 *   / \
 *  2   2
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 * 分析：特殊二叉树的每个结点都有0个或2个子结点，如果有2个子结点则该结点的值等于较小的那个结点的值，找它的第二小的结点。
 * 这棵特殊二叉树的根节点是最小结点，因此可以将题目转化为找左右子树中最小的结点，
 * 如果子结点的值等于根结点，则继续在子结点的子树中找最小的结点。。
 */
public class No_671 {
    public int findSecondMinimumValue(TreeNode root) {
        //分治，分别找左右子树的最小值
        if (root == null || root.left == null) {
            return -1;
        }
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) {
            leftVal = findSecondMinimumValue(root.left);
        }
        if (rightVal == root.val) {
            rightVal = findSecondMinimumValue(root.right);
        }
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }
        return leftVal != -1 ? leftVal : rightVal;
    }
}
