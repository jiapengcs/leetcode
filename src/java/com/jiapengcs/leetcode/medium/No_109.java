package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.ListNode;
import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 109. Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 * Given the sorted linked list: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 分析：将有序链表转化为二分查找树。
 * 与108题将有序数组转化为二分查找树思路是一致的，都是取中间结点作为根结点，左右两部分作为左右子树，递归建树。
 * 难点在于数组可以方便地取(start, mid - 1)作为左子树，(mid + 1, end)作为右子树；
 * 而链表只能是取(start, mid)作为左子树，(mid.next, end)作为右子树；这样mid结点会被重复访问，
 * 改进的方法是排除每个区间的右边界，起始的区间为(root, null).
 */
public class No_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return create(head, null);  //在end处添加一个空指针
    }

    private TreeNode create(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode fast = start, slow = start;
        //这里不包括end结点，因为单链表的原因我们只能取得mid+1（slow.next），无法取得mid-1，可以通过排除最后一个结点来实现。
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = create(start, slow);
        root.right = create(slow.next, end);
        return root;
    }
}
