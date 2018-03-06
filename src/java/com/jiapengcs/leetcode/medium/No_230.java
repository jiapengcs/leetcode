package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 230. Kth Smallest Element in a BST
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * 分析：求二分查找树第k小的值。
 * 即中序遍历的第k个结点。
 */
public class No_230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (++count == k) {
                return p.val;
            }
            p = p.right;
        }
        return -1;
    }
}
