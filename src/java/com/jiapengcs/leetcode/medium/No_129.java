package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-22
 *
 * 129. Sum Root to Leaf Numbers
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *      1
 *     / \
 *    2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 *
 */
public class No_129 {

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        return dfs(root.left, num) + dfs(root.right, num);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node3.right = node4;
        System.out.println(sumNumbers(root));
    }
}
