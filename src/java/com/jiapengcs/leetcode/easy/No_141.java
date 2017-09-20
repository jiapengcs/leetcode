package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jiapeng on 2017/9/17.
 *
 * 141. Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * 分析：判断单链表是否存在环。
 * 方法一：使用快慢指针，快指针每次向后移动两个结点，慢指针每次向后移动一个结点，如果快慢指针相遇则说明存在环。
 * 方法二：将遍历过的结点加入HashSet，如果遍历到相同的结点则说明存在环。
 */
public class No_141 {
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        ListNode node = head;
        Set<ListNode> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node)) return true;
            else set.add(node);
            node = node.next;
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
        System.out.println(hasCycle(node1));
    }
}
