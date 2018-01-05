package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-5
 *
 * 160. Intersection of Two Linked Lists
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * 分析：经典链表题，找两个链表的交点。
 * 方法一：先分别遍历求两个链表的长度，让较长的链表先走他们的长度差，使链表的尾端对齐，然后依次比较结点是否相同；
 * 方法二：用两个指针p, q，让它们都遍历两个链表，如果有交点则必定在交点相遇。
 */
public class No_160 {
    // TC: O(n), SC: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int lenA = 0, lenB = 0;
        for (; p != null; p = p.next) lenA++;
        for (; q != null; q = q.next) lenB++;
        p = headA;
        q = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) p = p.next;
        } else {
            for (int i = 0; i < lenB - lenA; i++) q = q.next;
        }
        while (p != null) {
            if (p == q) return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }

    // TC: O(n), SC: O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            p = (p == null ? headB : p.next);
            q = (q == null ? headA : q.next);
        }
        return p;
    }
}
