package com.jiapengcs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-26
 *
 * 138. Copy List with Random Pointer
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 *
 * 分析：Hash法
 */
public class No_138 {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    // TC: O(n), SC: O(n)
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1), p = dummy, q = head;
        while (q != null) {
            p.next = new RandomListNode(q.label);
            p = p.next;
            map.put(q, p);
            q = q.next;
        }
        p = dummy.next;
        q = head;
        while (q != null) {
            p.random = map.get(q.random);
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }
}