package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * Created by Jiapeng 2017/10/11.
 *
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list,
 * only nodes itself can be changed.
 *
 * 分析：
 * 方法一：借助双指针，可以一次遍历完成。（作图）
 * 方法二：递归。
 */
public class No_24 {
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode temp = node;
        while (temp.next != null && temp.next.next != null) {
            ListNode left = temp.next, right = temp.next.next;
            left.next = right.next;
            right.next = left;
            temp.next = right;
            temp = left;
        }
        return node.next;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head.next;
        head.next = swapPairs(head.next.next);
        node.next = head;
        return node;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{1, 2, 3, 4, 5, 6});
        ListNode.print(swapPairs(head));
    }
}
