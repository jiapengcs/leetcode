package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-25
 *
 * 147. Insertion Sort List
 *
 * Sort a linked list using insertion sort.
 *
 * 分析：
 * 将链表分为两部分，一部分为有序（初始为空），一部分待排序，将第二部分的结点依次插入第一部分。
 */
public class No_147 {

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1), p = head;
        while (p != null) {
            ListNode q = dummy;
            while (q.next != null && p.val >= q.next.val) {
                q = q.next;
            }
            ListNode next = p.next;
            p.next = q.next;
            q.next = p;
            p = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{1, 4, 2, 3});
        ListNode.print(insertionSortList(head));
    }
}
