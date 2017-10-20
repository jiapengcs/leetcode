package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * Created by Jiapeng 2017/10/20.
 *
 * 61. Rotate List
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 * 分析：先计算链表长度，令k =% length。再右移k步，则链表尾部倒数前k个结点将移动到头部，因此先找出倒数第k+1个结点，再重新连接。
 */
public class No_61 {
    // TC: O(n), SC: O(1)
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode p = head, q = head;
        int length = 1;
        while (p.next != null) {
            length++;
            p = p.next;
        }
        k %= length;
        while (++k < length) {
            q = q.next;
        }
        p.next = head;
        head = q.next;
        q.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{1, 2, 3, 4, 5});
        ListNode.print(head);
        ListNode.print(rotateRight(head, 7));
    }
}
