package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/16
 *
 * 206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * 分析：
 * 方法一：迭代，一次遍历。依次断开表头结点，头插法插入到逆序链表。
 * 方法二：迭代。先遍历找到表尾结点，再次遍历，依次将表头结点通过头插法插入表尾。
 * 方法三：递归。将链表分为表头结点(head)和剩余结点(head.next)两部分，对剩余结点递归调用reverse()，此时剩余部分已经逆置，
 * 因此head.next.next = head。
 */
public class No_206 {
    // TC: O(n), SC: O(1)
    public static ListNode reverseList1(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    // TC: O(n), SC: O(1)
    public static ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        while (head != tail) {
            ListNode tmp = head.next;
            head.next = tail.next;
            tail.next = head;
            head = tmp;
        }
        return tail;
    }

    // TC: O(n), SC: O(n)
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{1, 4, 3, 2, 5, 2});
        ListNode.print(reverseList1(head));
    }
}
