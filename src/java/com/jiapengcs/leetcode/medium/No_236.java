package com.jiapengcs.leetcode.medium;

import com.jiapengcs.leetcode.util.TreeNode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w
 * as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *             _______3______
 *            /              \
 *        ___5__          ___1__
 *       /      \        /      \
 *      6      _2       0       8
 *           /  \
 *          7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 * Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * 分析：找二叉树中两个结点的最小公共祖先。（祖先可以是某个结点本身）
 * 后序遍历二叉树：
 * 1. 如果root结点等于p或q结点，则直接返回root；
 * 2. 否则分别在左右子树中找最小公共祖先；
 * 3. 如果只在右子树找到最小公共祖先，返回右子树中的结果；
 *    如果只在右子树找到最小公共祖先，返回左子树中的结果；
 *    如果左右子树都找到，即p和q分布在root的左边和右边，最小公共祖先是root。
 *
 * 延伸：
 * 1. 二叉树是二分查找树，见235题；
 * 2. 二叉树结点有指向父节点的指针，可以转化为
 */
public class No_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;  //root等于p或q，最小公共祖先是root本身
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;  //只在右子树找到最小公共祖先，返回右子树中的结果
        if (right == null) return left;  //只在右子树找到最小公共祖先，返回左子树中的结果
        return root;  //左右子树都找到，即p和q分布在root的左边和右边，最小公共祖先是root
    }
}
