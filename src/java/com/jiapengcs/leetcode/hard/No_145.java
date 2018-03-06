package com.jiapengcs.leetcode.hard;

import com.jiapengcs.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-13
 *
 * 145. Binary Tree Postorder Traversal
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
 *    1
 *     \
 *     2
 *    /
 *   3
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * 分析：树的非递归后序遍历
 */
public class No_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode top = stack.peek();
            if (top.right != null && top.right != pre) {
                p = top.right;
            } else {
                stack.pop();
                ans.add(top.val);
                pre = top;
            }
        }
        return ans;
    }

    //-----------------------------------------------------
    //Morris Traversal
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        TreeNode p = dummy;
        while (p != null) {
            if (p.left != null) {
                TreeNode q = p.left;
                while (q.right != null && q.right != p) {
                    q = q.right;
                }
                if (q.right != p) {  //第一次到达p，构建线索
                    q.right = p;
                    p = p.left;
                } else {  //通过线索第二次到达p，删除线索
                    echo(p.left, q, ans);  //倒序输出p的左孩子到q的路径
                    q.right = null;
                    p = p.right;
                }
            } else {
                p = p.right;
            }
        }
        return ans;
    }

    public void echo(TreeNode from, TreeNode to, List<Integer> list) {
        reverse(from, to);
        TreeNode t = to;
        while (true) {
            list.add(t.val);
            if (t == from) {
                break;
            }
            t = t.right;
        }
        reverse(to, from);
    }

    public void reverse(TreeNode from, TreeNode to) {
        if (from == to) {
            return;
        }
        TreeNode s = from, t = from.right;
        while (true) {
            TreeNode tmp = t.right;
            t.right = s;
            if (t == to) {
                break;
            }
            s = t;
            t = tmp;
        }
    }
}
