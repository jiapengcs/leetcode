package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * Created by Jiapeng on 2017/9/17.
 */
public class No_141 {
    public static boolean hasCycle1(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && slow != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        System.out.println(hasCycle1(node1));
    }
}
