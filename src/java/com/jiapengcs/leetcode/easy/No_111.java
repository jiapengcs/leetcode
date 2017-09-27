package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jiapeng 2017/9/26.
 *
 * 111. Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * 分析：求二叉树的最小深度（与104题对应）
 * 方法一：递归先序遍历每个结点，返回其左右子树中较小的高度。注意如果有子树为空，则应该返回另一棵子树的高度，而不是0.
 * 方法二：层次遍历，记录层数，找到第一个叶子结点，此时的层数即最小深度。
 */
public class No_111 {
    // TC: O(n), SC: O(1)
    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        return (left == 0 || right == 0) ? (left + right + 1) : Math.min(left, right) + 1;
    }

    // TC: O(n), SC: O(n)
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        TreeNode.preOderTraversalRecursive(node1);
        System.out.println("*****");
        System.out.println(minDepth2(node1));
    }
}
