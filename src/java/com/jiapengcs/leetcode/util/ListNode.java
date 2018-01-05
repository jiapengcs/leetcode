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

    public static ListNode link(ListNode[] nodes) {
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }

    public static ListNode link(int[] values) {
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
        }
        return link(nodes);
    }

    public static void print(ListNode head) {
        ListNode node = head;
        if (node != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(node.val);
            while (node.next != null) {
                node = node.next;
                sb.append(" -> ").append(node.val);
            }
            System.out.println(sb.toString());
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

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("D"));
    }
}
