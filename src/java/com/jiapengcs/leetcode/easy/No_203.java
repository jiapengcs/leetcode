package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/30
 *
 * 203. Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class No_203 {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1), p = dummy;
        dummy.next = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{6,1,2,6,3,4,5,6});
        ListNode.print(removeElements(head, 6));
    }
}
