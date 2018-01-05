package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-4
 *
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * 分析：依次根据preorder中的结点将inorder中的结点划分到左右子树。
 */
public class No_105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, 0, inorder.length-1);
    }

    public static TreeNode build(int[] preorder, int[] inorder, int p, int s, int e) {
        if (s > e) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[p]);
        int i = s;
        for (; i <= e && inorder[i] != preorder[p]; i++);
        node.left = build(preorder, inorder, p+1, s, i-1);
        node.right = build(preorder, inorder, p+i-s+1, i+1, e);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{1,2,3}, new int[]{2,1,3});
        TreeNode.levelTraversal(root);
    }
}
