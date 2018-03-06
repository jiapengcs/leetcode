package com.jiapengcs.leetcode.hard;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-26
 *
 * 99. Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 * 分析：搜索二叉树有两个结点交换了，使用O(1)空间将它们恢复。
 * 限制O(1)空间复杂度，考虑使用Morris遍历，找到两个不符合中序遍历的结点，交换结点值。
 */
public class No_99 {
    public void recoverTree(TreeNode root) {
        TreeNode p = root;
        TreeNode first = null, second = null, pre = null;
        while (p != null) {
            if (p.left != null) {
                TreeNode q = p.left;
                while (q.right != null && q.right != p) {
                    q = q.right;
                }
                if (q.right != p) {
                    q.right = p;
                    p = p.left;
                } else {
                    //-------------访问函数--------------
                    if (pre != null && pre.val > p.val) {
                        if (first == null) {
                            first = pre;
                        }
                        second = p;
                    }
                    pre = p;
                    //-----------------------------------
                    q.right = null;
                    p = p.right;
                }
            } else {
                //-------------访问函数--------------
                if (pre != null && pre.val > p.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = p;
                }
                pre = p;
                //-----------------------------------
                p = p.right;
            }
        }
        if (first != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.deserialize("4,5,6,1,3,2,7");
        TreeNode root = TreeNode.deserialize("0,1,null");
        new No_99().recoverTree(root);
    }
}
