package com.dyh.algorithms4.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/9 下午10:30
 * @description:
 */
public class LowestCommonAncestorOfABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, TreeNode> parents = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != null) {
            visited.add(p.val);
            p = parents.get(p);
        }

        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }

            q = parents.get(q.val);
        }

        return null;
    }


    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            parents.put(node.left.val, node);
            dfs(node.left);
        }

        if (node.right != null) {
            parents.put(node.right.val, node);
            dfs(node.right);
        }

    }
}
