package com.jiapengcs.leetcode.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/30
 *
 * 快速排序
 */
public class QuickSort {

    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int low = start, high = end, pivot = nums[end];
            while (low < high) {
                if (nums[low++] > pivot) {
                    swap(nums, --low, --high);
                }
            }
            swap(nums, low, end);
            quickSort(nums, start, low-1);
            quickSort(nums, low+1, end);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //--------------------------------------------------------------
    // 单链表的快速排序
    public static void linkedListSort(ListNode head) {
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        linkedListQuickSort(head, tail);
    }

    public static void linkedListQuickSort(ListNode start, ListNode end) {
        if (start == null || start == end) {
            return;
        }
        ListNode p = start.next, q = start;
        while (p != null) {
            if (p.val < start.val) {
                q = q.next;
                swapVal(q, p);
            }
            p = p.next;
        }
        swapVal(start, q);
        linkedListQuickSort(start, q);
        linkedListQuickSort(q.next, end);
    }

    public static void swapVal(ListNode a, ListNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    //------------------- TEST ---------------------------
    public static void main(String[] args) {
        int[] nums = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Random().nextInt(100000000);
        }
        long start = System.currentTimeMillis();
//        sort(nums);
        Arrays.sort(nums);
        long end = System.currentTimeMillis();

//        System.out.println(Arrays.toString(nums));
        System.out.println(end - start);

        ListNode head = ListNode.link(new int[]{6,1,5,3,2,4});
        linkedListSort(head);
        ListNode.print(head);
    }
}
