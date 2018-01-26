package com.jiapengcs.leetcode.hard;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-23
 *
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * 分析：分治法，过程与归并排序一致。
 */
public class No_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divide(lists, 0, lists.length-1);
    }

    private ListNode divide(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        return merge(divide(lists, start, mid), divide(lists, mid+1, end));
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        if (a != null) {
            p.next = a;
        }
        if (b != null) {
            p.next = b;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.link(new int[]{1,4,7});
        ListNode list2 = ListNode.link(new int[]{2,5,8});
        ListNode list3 = ListNode.link(new int[]{3,6,9});
        ListNode[] lists = new ListNode[]{list1, list2, list3};
        ListNode.print(new No_23().mergeKLists(lists));
    }
}
