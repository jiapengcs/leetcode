package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * Created by Jiapeng 2017/9/27.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * 分析：类似于链表的归并。需要注意的是最后一位是否进位。
 */
public class No_2 {
    // TC: O(max(m, n)), SC: O(max(m, n))
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            p = p.next;
            sum /= 10;
        }
        if (sum != 0) {
            p.next = new ListNode(sum);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(7);
        ListNode node13 = new ListNode(1);
        node11.next = node12;
        node12.next = node13;
        System.out.println("******");
        ListNode.print(node11);

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(5);
        ListNode node23 = new ListNode(8);
        ListNode node24 = new ListNode(9);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        System.out.println("******");
        ListNode.print(node21);

        System.out.println("******");
        ListNode.print(addTwoNumbers(node11, node21));
    }
}
