package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-21
 *
 * 142. Linked List Cycle II
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 * 分析：
 * 方法一：依次将结点加入List，第一个遇到的遍历过的结点，即环的入口。
 * 方法二：由于本题限制不能使用额外空间，采用双指针法。
 * 1)首先，使用快慢指针，快指针步长为2，慢指针步长为1，根据是否相遇判断是否有环，如果有环则通过两次相遇来判断环的长度；
 * 2)然后，仍然使用快慢指针，步长都为1，让快指针先走一个环的长度，最终快慢指针会在环的入口相遇。
 * 简化：1)中快慢指针首次相遇时，恰好是快指针比慢指针多走了t个环的长度，因此只需要让慢指针回到起点，然后快慢指针都以
 * 步长1移动，最终在环的入口相遇。但该思路可以用来求环的长度。
 * 证明：假设链表直链长度为m，环长n，快慢指针相遇时，慢指针在环中走了k步。则快慢指针分别走了(m+k)、2(m+k)步，此时快指针多走了
 * t个环的长度，有等式：2(m+k) - (m+k) = n * t, => m = n * t - k = n * (t - 1) + (n - k).
 * 所以用两个步长为1的指针，一个从头开始走m步，另一个从相遇点开始走n * (t - 1) + (n - k)步，最后相遇在环的入口。
 */
public class No_142 {
    // TC: O(n), SC: O(1)
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // TC: O(n), SC: O(n)
    public static ListNode detectCycle2(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            if (!list.contains(p)) {
                list.add(p);
                p = p.next;
            } else {
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(detectCycle(head).val);
    }
}
