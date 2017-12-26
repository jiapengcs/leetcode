package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-26
 *
 * 114. Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 分析：Morris遍历
 */
public class No_114 {

    public static void flatten(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            if (p.left != null) {
                TreeNode q = p.left;
                while (q.right != null) {
                    q = q.right;
                }
                q.right = p.right;
                p.right = p.left;
                TreeNode next = p.left;
                p.left = null;
                p = next;
            } else {
                p = p.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(6);
        node3.right = node6;
        flatten(root);
        TreeNode.levelTraversal(root);
    }
}
