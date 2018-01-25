package com.jiapengcs.leetcode.hard;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/24
 *
 * 25. Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * 分析：按步长k逆置单链表
 * 1. 可以先断开前面的k个结点，将它们逆置；对后面的部分进行递归，将结果链接在前k个结点后面。
 * 2. 也可以先对后面的部分先递归，然后将前k个结点通过头插法链接到结果前面。
 * 复杂度都为O(n)
 */
public class No_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        int count = 1;
        while (tail.next != null && count < k) {
            tail = tail.next;
            count++;
        }
        if (count < k) return head;
        ListNode child = tail.next;
        tail.next = null;
        tail = reverse(head);
        head.next = reverseKGroup(child, k);
        return tail;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    // 讨论区
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode p = head;
        int count = 0;
        while (p != null && count < k) {
            p = p.next;
            count++;
        }
        if (count == k) {
            p = reverseKGroup2(p, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = p;
                p = head;
                head = tmp;
            }
            head = p;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{1, 2, 3, 4, 5});
        head = new No_25().reverseKGroup2(head, 3);
        ListNode.print(head);
    }
}
