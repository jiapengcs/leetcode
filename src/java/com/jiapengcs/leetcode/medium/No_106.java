package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-4
 *
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class No_106 {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, postorder.length-1, 0, postorder.length-1);
    }

    public static TreeNode build(int[] inorder, int[] postorder, int p, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[p]);
        int i = inorder.length - 1;
        for (; i >= 0 && inorder[i] != postorder[p]; i--);
        node.right = build(inorder, postorder, p-1, i+1, end);
        node.left = build(inorder, postorder, p-1-(end-i), start, i-1);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{2,1,3}, new int[]{2,3,1});
        TreeNode.levelTraversal(root);
    }
}
