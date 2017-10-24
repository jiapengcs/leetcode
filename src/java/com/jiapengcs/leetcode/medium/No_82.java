package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * Created by Jiapeng 2017/10/24.
 *
 * 82. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 * 分析：83题的变种。如果head结点的值与后面的结点相同，则跳过这些值相同的结点，然后对后面的结点进行递归操作。
 */
public class No_82 {
    // TC: O(n), SC: O(1)
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        while (p != null && p.val == head.val) {
            p = p.next;
        }
        if (p != head.next) {  // duplicates found
            return deleteDuplicates(p);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }

    // TC: O(n), SC: O(1)
    public static ListNode deleteDuplicates1(ListNode head) {
        while (head != null && head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        if (head != null) {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{1, 1, 2, 3});
        head = deleteDuplicates(head);
        ListNode.print(head);
    }
}
