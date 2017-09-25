package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jiapeng 2017/9/21.
 *
 * 104. Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * 分析：DFS, BFS求树的最大深度
 */
public class No_104 {
    // TC: O(n), SC: O(1)
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // TC: O(n), SC: O(n)
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int length = queue.size();
            while (length-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
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
        System.out.println(maxDepth2(node1));
    }
}
