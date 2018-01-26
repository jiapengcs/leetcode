package com.jiapengcs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/23
 *
 * 117. Populating Next Right Pointers in Each Node II
 *
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *
 * 分析：二叉树按层连接，与116题类似。
 */
public class No_117 {
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

    public void connect2(TreeLinkNode root) {
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
}
