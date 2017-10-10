package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * Created by Jiapeng 2017/10/10.
 *
 * 19. Remove Nth Node From End of List
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * 分析：移除链表的倒数第n个结点。要求一次遍历完成。
 * 双指针，快指针先走n位，然后快慢指针同时后移，快指针到达末尾时，慢指针正好指向倒数第n+1个结点，
 * 然后将该结点的指针指向第n个结点的后继结点。
 */
public class No_19 {
    // TC: O(n), SC: O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(-1), fast = tmp, slow = tmp;
        tmp.next = head;
        for (int i = 1; fast.next != null; i++) {
            fast = fast.next;
            if (i > n) {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{1, 2, 3, 4, 5});
        ListNode.print(removeNthFromEnd(head, 5));
    }
}
