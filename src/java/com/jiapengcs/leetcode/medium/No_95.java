package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-20
 *
 * 95. Unique Binary Search Trees II
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 */
public class No_95 {

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

        }
        return null;
    }

    public static TreeNode backtracking(int n, TreeNode root, List<Integer> buf, List<TreeNode> list) {
        if (buf.size() == n) {
            list.add(root);
        }
        for (int i = 1; i <= n; i++) {
            if (!buf.contains(i)) {
                TreeNode node = new TreeNode(i);
                if (root != null && i > root.val) {
                    root.right = node;
                }
                if (root != null && i < root.val) {
                    root.left = node;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<TreeNode> nodes = generateTrees(3);
        assert nodes != null;
        for (TreeNode node : nodes) {
            TreeNode.preOderTraversalRecursive(node);
        }
    }
}
