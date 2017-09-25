package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * Created by Jiapeng on 2017/9/6.
 *
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
 * nodes of the first two lists.
 *
 * 分析：首先p指针指向头结点head，l1、l2分别指向两个链表的第一个节点，令p指向l1, l2中较小的节点，同时将p, l1或l2指针后移。
 * 最后将p指针指向剩下的链表（l1和l2中非空的那个）。
 */
public class No_21 {
    // TC: O(m+n), SC: O(1)
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;
        return head.next;
    }

    //TODO:递归方法

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(5);
        node11.next = node12;
        node12.next = node13;
        ListNode.print(node11);
        System.out.println("*****************");
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(6);
        ListNode node24 = new ListNode(8);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        ListNode.print(node21);
        System.out.println("*****************");
        ListNode merge = mergeTwoLists(node11, node21);
        ListNode.print(merge);
    }
}
