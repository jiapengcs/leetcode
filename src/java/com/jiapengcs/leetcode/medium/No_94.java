package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-19
 *
 * 94. Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 *  1
 *   \
 *   2
 *  /
 * 3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * 分析：
 * 最简单的方法是通过递归，迭代法需要借助栈来实现。
 * 方法三是Morris Traversal，该方法遍历不需要借助额外的空间。
 */
public class No_94 {
    // TC: O(n), SC: O(n)
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        inorder(root, answer);
        return answer;
    }

    public static void inorder(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(root.right, list);
        }
    }

    // TC: O(n), SC: O(n)
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            answer.add(node.val);
            p = node.right;
        }
        return answer;
    }

    // TC: O(n), SC: O(n)
    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        TreeNode p = root;
        TreeNode q;
        while (p != null) {
            if (p.left != null) {
                q = p.left;
                while (q.right != null) {
                    q = q.right;
                }
                q.right = p;
                TreeNode next = p;
                p = p.left;
                next.left = null;
            } else {
                answer.add(p.val);
                p = p.right;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        System.out.println(inorderTraversal3(node1));
    }
}
