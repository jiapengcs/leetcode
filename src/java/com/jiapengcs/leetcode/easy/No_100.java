package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * Created by Jiapeng 2017/9/12.
 *
 * 100. Same Tree
 *
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * 分析：递归先序遍历，依次比较每个对应结点
 */
public class No_100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p != null && q != null)
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        node11.left = node12;
        node11.right = node13;
        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);
        node21.left = node22;
        node21.right = node23;
        TreeNode.preOderTraversalRecursive(node11);
        TreeNode.preOderTraversalRecursive(node21);
        System.out.println(isSameTree(node11, node21));
    }
}
