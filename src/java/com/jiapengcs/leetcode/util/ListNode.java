package com.jiapengcs.leetcode.util;

/**
 * Created by Jiapeng 2017/9/11.
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static int count(ListNode node) {
        int cnt = 0;
        while (node != null) {
            cnt++;
            node = node.next;
        }
        return cnt;
    }
}
