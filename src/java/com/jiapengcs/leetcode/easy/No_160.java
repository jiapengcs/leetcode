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
 * 方法二：用两个指针p, q，让它们都遍历两个链表，如果有交点则必定在交点相遇。（如果没有交点p, q最终都等于null，返回空指针）
 */
public class No_160 {
    // TC: O(n), SC: O(1)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int lenA = 0, lenB = 0;
        for (; p != null; p = p.next) lenA++;
        for (; q != null; q = q.next) lenB++;
        p = lenA >= lenB ? headA : headB;
        q = lenA >= lenB ? headB : headA;
        for (int i = 0; i < Math.abs(lenA - lenB); i++) p = p.next;
        while (p != null) {
            if (p == q) return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }

    // TC: O(n), SC: O(1)
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            p = (p == null ? headB : p.next);
            q = (q == null ? headA : q.next);
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node21 = new ListNode(3);
        node11.next = node2;
        node2.next = node3;
        System.out.println(getIntersectionNode2(node11, node21).val);
    }
}
