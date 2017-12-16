package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/16
 *
 * 86. Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class No_86 {
    // TC: O(n), SC: O(1)
    public static ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1), greater = new ListNode(-1);
        ListNode p = less, q = greater;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = greater.next;
        return less.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{1, 4, 3, 2, 5, 2});
        head = partition(head, 3);
        ListNode.print(head);
    }
}
