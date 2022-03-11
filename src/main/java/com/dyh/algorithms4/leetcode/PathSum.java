package com.dyh.algorithms4.leetcode;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/9 下午11:11
 * @description: https://leetcode-cn.com/problems/path-sum/
 */
public class PathSum {

    public class TreeNode {
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


    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }

        sum = sum + node.val;
        if (node.left == null && node.right == null) {
            return sum == targetSum;
        }

        return dfs(node.left, sum, targetSum) || dfs(node.right, sum, targetSum);
    }
}
