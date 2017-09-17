package com.jiapengcs.leetcode.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jiapeng 2017/9/11.
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void preOderTraversalRecursive(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOderTraversalRecursive(root.left);
            preOderTraversalRecursive(root.right);
        }
    }

    public static void preOderTraversalNonRecursive(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.println(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }
    }

    public static void levelTraversal(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                System.out.println(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }

    public static void levelTraversalWithLevelNumber(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 1;
            while (!queue.isEmpty()) {
                int length = queue.size();
                while (length-- > 0) {
                    TreeNode node = queue.poll();
                    System.out.println("val: " + node.val + ", level: " + level);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                level++;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node4.left = node5;
        node2.right = node4;
        node1.left = node2;
        node1.right = node3;
        preOderTraversalRecursive(node1);
        preOderTraversalNonRecursive(node1);
        levelTraversalWithLevelNumber(node1);
        levelTraversal(node1);
    }
}
