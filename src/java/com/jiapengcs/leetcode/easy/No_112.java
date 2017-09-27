package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * Created by Jiapeng 2017/9/26.
 *
 * 112. Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *        5
 *       / \
 *      4   8
 *     /   / \
 *    11  13  4
 *   /  \      \
 *  7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * 分析：求二叉树是否有指定的路径和。先序遍历，每经过一个结点，减去该结点上的值。若找到一个结点值等于剩下的sum值，且为叶子结点，
 * 则存在这样的路径。
 */
public class No_112 {
    // TC: O(n), SC: O(1)
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        TreeNode.preOderTraversalRecursive(node1);
        System.out.println("*****");
        System.out.println(hasPathSum(node1, 7));
        System.out.println(hasPathSum(node1, 9));
        System.out.println(hasPathSum(node1, 1));
        System.out.println(hasPathSum(node1, 2));
        System.out.println(hasPathSum(node1, 3));
        System.out.println(hasPathSum(node1, 4));
        System.out.println(hasPathSum(node1, 5));
        System.out.println(hasPathSum(node1, 6));
        System.out.println(hasPathSum(node1, 8));
        System.out.println(hasPathSum(node1, 0));
    }
}
