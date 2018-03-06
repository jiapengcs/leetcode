package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-22
 *
 * 144. Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 分析：
 * 最简单的方法是通过递归，迭代法需要借助栈来实现。
 */
public class No_144 {
    // TC: O(n), SC: O(n)
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }

    // TC: O(n), SC: O(n)
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    public static void preorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

    // Morris遍历
    public static List<Integer> preorderTraversal3(TreeNode root) {
        TreeNode p = root;
        List<Integer> ans = new ArrayList<>();
        while (p != null) {
            if (p.left != null) {
                TreeNode q = p.left;
                while (q.right != null && q.right != p) {
                    q = q.right;
                }
                if (q.right != p) {  //第一次到达p，构建线索
                    ans.add(p.val);  //访问p结点（此处的p结点为中间结点）
                    q.right = p;
                    p = p.left;
                } else {  //通过线索第二次到达p，删除线索
                    q.right = null;
                    p = p.right;
                }
            } else {
                ans.add(p.val);  //访问p结点（此处的p结点为叶子结点）
                p = p.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;
        System.out.println(preorderTraversal3(root));
    }
}
