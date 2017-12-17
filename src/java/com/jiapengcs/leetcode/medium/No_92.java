package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/17
 *
 * 92. Reverse Linked List II
 *
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 *
 * 分析：此类问题应作图理解。
 */
public class No_92 {
    // TC: O(n), SC: O(1)
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode h = dummy;
        for (int i = 0; i < m - 1; i++){
            h = h.next;
        }
        ListNode p = h.next, q = p.next;
        for (int i = 0; i < n - m; i++) {
            p.next = q.next;
            q.next = h.next;
            h.next = q;
            q = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{1, 2, 3, 4, 5});
        ListNode.print(reverseBetween(head, 2, 4));
    }
}
