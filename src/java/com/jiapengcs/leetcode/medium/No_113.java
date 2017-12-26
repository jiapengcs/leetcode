package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-25
 *
 * 113. Path Sum II
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class No_113 {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), ans);
        return ans;
    }

    public static void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            ans.add(new ArrayList<>(list));
        }
        dfs(root.left, sum, list, ans);
        dfs(root.right, sum, list, ans);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode(11);
        node2.left = node4;
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        node3.left = node5;
        node3.right = node6;
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        node4.left = node7;
        node4.right = node8;
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node6.left = node9;
        node6.right = node10;
        System.out.println(pathSum(root, 22));
    }
}
