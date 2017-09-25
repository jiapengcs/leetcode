package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * Created by Jiapeng on 2017/9/25.
 *
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * 分析：由于给定的是有序数组，通过递归二分建树。
 */
public class No_108 {
    // TC: O(n), SC: O(1)
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return create(nums, 0, nums.length-1);
    }

    public static TreeNode create(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = create(nums, low, mid-1);
        node.right = create(nums, mid+1, high);
        return node;
    }

    public static void main(String[] args) {
        TreeNode.preOderTraversalRecursive(sortedArrayToBST(new int[]{1, 2, 3, 4, 5}));
        TreeNode.preOderTraversalRecursive(sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6}));
        TreeNode.preOderTraversalRecursive(sortedArrayToBST(new int[]{1}));
        TreeNode.preOderTraversalRecursive(sortedArrayToBST(new int[]{}));
    }
}
