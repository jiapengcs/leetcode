package com.jiapengcs.leetcode.easy;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w
 * as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *           _______6______
 *          /              \
 *      ___2__          ___8__
 *     /      \        /      \
 *    0      _4       7       9
 *         /  \
 *        3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 * Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 * 分析：找二分查找树中两个结点的最小公共祖先。（祖先可以是某个结点本身）
 * 通过分析发现两个结点的最小公共祖先有两种情况：
 * 1. 是其中一个结点本身；
 * 2. 结点值介于两个结点值的之间的某个结点。
 */
public class No_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val < p.val && root.val < q.val) {  //root值小于p, q的值，在右子树找
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {  //root值大于p, q的值，在左子树找
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;  //其他情况：root值等于p或q，或者root值介于p, q之间。
    }
}
