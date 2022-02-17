package com.dyh.algorithms4.leetcode;

/**
 * @author: dengyunhui
 * @datetime: 2022/2/17 下午6:10
 * @description: 二叉树最小深度
 */
public class BinaryTreeMinDepth {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.right == null && root.left == null) {
            return 1;
        } else if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        } else if (root.right != null && root.left == null) {
            return 1 + minDepth(root.right);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
