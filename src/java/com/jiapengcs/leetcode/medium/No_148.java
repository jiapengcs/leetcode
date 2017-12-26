package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-26
 *
 * 148. Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * 分析：归并排序
 * 递归地将链表分为两部分，对这两部分分别排序，然后将两部分归并。
 */
public class No_148 {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(mid));
    }

    public static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        p.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{2, 3, 4, 5, 1, 3, 4, 5, 5});
        head = sortList(head);
        ListNode.print(head);
    }
}
