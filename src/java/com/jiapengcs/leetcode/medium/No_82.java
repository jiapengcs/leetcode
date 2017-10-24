package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * Created by Jiapeng 2017/10/24.
 *
 * 82. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 * 分析：83题的变种。
 */
public class No_82 {
    public static ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.link(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode.print(head);
    }
}
