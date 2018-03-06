package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-3
 *
 * 538. Convert BST to Greater Tree
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 * Input: The root of a Binary Search Tree like this:
 *     5
 *   /   \
 *  2     13
 * Output: The root of a Greater Tree like this:
 *     18
 *   /   \
 * 20     13
 */
public class No_538 {
    public TreeNode convertBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> buf = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            buf.push(p);
            p = p.right;
        }
        int tmp = 0;
        while (!buf.empty()) {
            p = buf.pop();
            tmp += p.val;
            p.val = tmp;
        }
        return root;
    }

    private int tmp = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        tmp += root.val;
        root.val = tmp;
        convertBST(root.left);
        return root;
    }
}
