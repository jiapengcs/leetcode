package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * Created by Jiapeng 2017/9/13.
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 分析：给定一棵二叉树，判断是否对称二叉树。将树分为左右两棵子树，判断左子树的左孩子与右子树的右孩子、左子树的右孩子和右子树的左孩子是否
 * 相等。可以用递归、非递归两种方法实现。
 */
public class No_101 {
    // TC: O(n), SC: O(1)
    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricTrees(root.left, root.right);
    }

    /**
     * 每遍历到一个结点：
     * 1.比较p, q的值是否相等
     * 2.p的左子树与q的右子树、p的右子树与q的左子树是否相等
     * @param p
     * @param q
     * @return
     */
    public static boolean isSymmetricTrees(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p != null && q != null)
            return p.val == q.val && isSymmetricTrees(p.left, q.right) && isSymmetricTrees(p.right, q.left);
        return false;
    }

    // TC: O(n), SC: O(n)
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null) {
            Stack<TreeNode> lstack = new Stack<>(), rstack = new Stack<>();
            lstack.push(root.left);
            rstack.push(root.right);
            while (!lstack.empty() && !rstack.empty()) {
                TreeNode lnode = lstack.pop(), rnode = rstack.pop();
                if (lnode.val != rnode.val) return false;
                if (lnode.right != null && rnode.left != null) {
                    lstack.push(lnode.right);
                    rstack.push(rnode.left);
                }
                if (lnode.left != null && rnode.right != null) {
                    lstack.push(lnode.left);
                    rstack.push(rnode.right);
                }
                if (lnode.right != null && rnode.left == null || lnode.right == null && rnode.left != null ||
                        lnode.left != null && rnode.right == null || lnode.left == null && rnode.right != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        node2.left = node4;
        node3.right = node5;
        node1.left = node2;
        node1.right = node3;
        TreeNode.preOderTraversalRecursive(node1);
        System.out.println(isSymmetric(node1));
        System.out.println(isSymmetric2(node1));
    }
}
