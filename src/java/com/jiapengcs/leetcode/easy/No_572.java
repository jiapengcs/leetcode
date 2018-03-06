package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-3
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values
 * with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 * 分析：给定两棵非空二叉树s和t，判断t是否为s的子树。
 */
public class No_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean subtree = false;
        if (s.val == t.val) {
            subtree = isEqual(s, t);
        }
        return subtree || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }
}
