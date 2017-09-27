package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * Created by Jiapeng 2017/9/26.
 *
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 *
 * 分析：判断一棵二叉树是否为平衡二叉树
 * 方法一：递归遍历每个结点，判断其左右子树的高度差是否不大于1，复杂度为O(n)；同时求每棵子树高度的复杂度为O(n)。总的复杂度为O(n^2)。
 * 方法二：上述方法自上而下，计算高度差的时候重复遍历底层结点。如果改为自下而上遍历，遇到非平衡的子树则停止遍历，这样可以避免重复遍历，
 * 复杂度降至O(n)。
 */
public class No_110 {
    // TC: O(n^2), SC: O(1)
    public static boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // TC: O(n), SC: O(1)
    public static boolean isBalanced2(TreeNode root) {
        return height(root) != -1;
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lH = height(node.left);
        if (lH == -1) {
            return -1;
        }
        int rH = height(node.right);
        if (rH == -1) {
            return -1;
        }
        if (Math.abs(lH - rH) > 1) {
            return -1;
        }
        return Math.max(lH, rH) + 1;
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
        System.out.println(isBalanced2(node1));
        System.out.println(isBalanced2(null));
    }
}
