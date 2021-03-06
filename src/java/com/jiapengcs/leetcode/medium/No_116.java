package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-26
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node
 *
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 *
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 *
 * 分析：完全二叉树按层连接
 * 1.借助队列实现层次遍历
 * 2.利用next指针直接层次遍历，不需额外空间
 */
public class No_116 {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode pre = null;
            while (size-- > 0) {
                TreeLinkNode node = queue.remove();
                if (pre != null) {
                    pre.next = node;
                }
                pre = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    // 参考答案，借助next指针实现按层遍历，同时利用完全二叉树的特点，转到下一层
    public void connect2(TreeLinkNode root) {
        TreeLinkNode level = root;
        while (level != null) {
            TreeLinkNode p = level;
            while (p != null) {
                if (p.left != null) {
                    p.left.next = p.right;
                }
                if (p.right != null && p.next != null) {
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
            level = level.left;
        }
    }

    public void connect3(TreeLinkNode root) {
        // 借助链表完成一层的连接
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode p = dummy, level = root;
        while (level != null) {
            if (level.left != null) {
                p.next = level.left;
                p = p.next;
            }
            if (level.right != null) {
                p.next = level.right;
                p = p.next;
            }
            level = level.next;
            // 本层已遍历完，level指向下一层第一个结点，即链表的第一个结点，清空链表
            if (level == null) {
                level = dummy.next;
                dummy.next = null;
                p = dummy;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.left = node6;
        node3.right = node7;
        No_116 no_116 = new No_116();
        no_116.connect(node1);
    }
}
