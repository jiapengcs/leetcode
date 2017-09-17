package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * Created by Jiapeng on 2017/9/11.
 *
 * 83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * 分析：双指针，注意断开值相同的结点之间的指针
 */
public class No_83 {
    // TC: O(n), SC: O(1)
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head, q = head.next;
        while (q != null) {
            if (q.val != p.val) {
                p.next = q;
                p = q;
            }
            q = q.next;
            p.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode.print(deleteDuplicates(node1));
    }
}
