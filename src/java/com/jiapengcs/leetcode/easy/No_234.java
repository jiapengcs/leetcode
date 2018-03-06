package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.ListNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-24
 *
 * 234. Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * 分析：判断链表是否回文。
 * 先用快慢指针找到中间位置，将其中一半翻转，然后比较两部分链表。
 */
public class No_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode right = reverse(slow);
        ListNode left = head;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println(new No_234().isPalindrome(ListNode.link(new int[]{3,2,2,3})));
    }
}
