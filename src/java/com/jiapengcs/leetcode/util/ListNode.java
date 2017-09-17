package com.jiapengcs.leetcode.util;

/**
 * Created by Jiapeng 2017/9/11.
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static int count(ListNode head) {
        ListNode node = head;
        int cnt = 0;
        while (node != null) {
            cnt++;
            node = node.next;
        }
        return cnt;
    }
}
